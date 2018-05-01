/*---------------------------------------------------------------------------
 * TAREK AIT HAMOUDA 
 * ID: 40044119
 * ASSIGNMENT 2 Q4
 * 
 * this fully functional programs reads arithmetic expression lines from a file called 
 * Arithmetic.txt and prints back the expression inside another file called NewFile1.txt
 * with its result printed in the next line
 * 
 * IMPORTANT NOTES : 
 * it is assumed that a '-' unary operator needs to either come at the beignng of the expression, 
 * or right after an operator, an example : 5 + - 2 or 5 +- 2
 * the expressions inside the file are expected to be entered in the specified format : 
 * one space between a number and operator.
 * Also the expressions needs to be ended with a '$'
 * -- the result 1 represents TRUE and 0 for FALSE for operations such as > < >= <= == !=
 * I included both files so they can be tested
 * ---------------------------------------------------------------------------
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class QuestionFourFinal {
	public static Stack<Integer> valStk = new ArrayStack<Integer>();
	public static Stack<Character> opStk = new ArrayStack<Character>();
	
	public static void main(String[] args) throws IOException {
		File file = new File("Arithmetic.txt");
		
		PrintStream o = new PrintStream(new File("NewFile1.txt"));
		
		PrintStream console = System.out;
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String st;
		
		while ((st = br.readLine()) != null) {
		
			System.setOut(o);
			
			System.out.println(st);
			
			System.out.println(evalExpression(st));
		}
		br.close();
		console.close();
		o.close();
	}
// factorial method, returns the factorial of a number
	public static int factorial(int num){
	if(num == 0) return 1;
	if(num == 1) return 1;
	else
	return num * factorial(num-1);
	}

	public static int precValue(char refOp){
		switch(refOp){
		case '(' : 
			return 9;
		case '!' :
			return 2;
		case 'U':
			return 3;
		case '^':
			return 4;
		case '*':
		case '/' : 
			return 5;
		case '+' : 
		case '-' : 
			return 6;
		case '>':
		case '<':
		case '≤':
		case '≥':
			return 7;
		case 'E': 
			return 8;
		case 'N':
			return 8;	
		case '$' : 
			return 9;
		default : 
			return -1;
		}
	}
	public static boolean hasPrecedence(char refOp){
		return precValue(refOp) >= precValue(opStk.top());
	}
	public static boolean isNumber(char a){
		return (a >= '0' && a <= '9');
		
	}
	public static void doOperation(){
		char op = opStk.pop();
		int x = 0;
		int y = 0;
		if ( op == '!' || op == 'U')
			x = valStk.pop();
		else {
			x = valStk.pop();
			y = valStk.pop();	
		}
		int result = 0;
		switch(op){
		case 'E': 
			if (y == x)
				result = 1;
			else if (y != x)
				result = 0;
			break;
		case '!':
			result = factorial(x) ;
			break;
		case '^':
			result = (int)(Math.pow((double)y,(double)x));
			break;
		case '*':
			result = (y*x);
			break;
		case '/' : 
			if (x == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			result = (y/x);
			break;
		case '+' : 
			result = (y+x);
			break;
		case '-' : 
			result = (y-x);
			break;
		
		case 'N':
			if (y != x)
				result = 1;
			else
				result = 0;
			break;
		case '>':
			if (y > x)
				result = 1;
			else 
				result = 0;
			break;
		case '<':
			if (y < x)
				result = 1;
			else 
				result = 0;
			break;
		case '≤':
			if (y <= x)
				result = 1;
			else 
				result = 0;
			break;
		case '≥':
			if (y >= x)
				result = 1;
			else 
				result = 0;
			break;
		case 'U' :
			result = 0-x;
			break;
	
		}
		valStk.push(result);
	}
	public static void repeatOps(char refOp){
		
		while (opStk.size() > 0 && hasPrecedence(refOp)){
			doOperation();
		}
			//valStk.push(doOp(opStk.pop(), valStk.pop(), valStk.pop()));
	}
	public static int evalExpression(String expression){
		// convert into array
		char[] tokens = expression.toCharArray();
		
		int current = 0; // index that serve to loop array
		
		while(current < tokens.length){ //looping through the expression array
			if (tokens[current] == '$'){
				repeatOps('$');
				return  valStk.top();
			}
			// skip the white spaces
			if (tokens[current] == ' ')
			{   
				current++;
				continue;
			}
			if (isNumber(tokens[current]))
			{
				StringBuffer sbuf = new StringBuffer();
				while (current < tokens.length && isNumber(tokens[current]))
					sbuf.append(tokens[current++]);
				valStk.push(Integer.parseInt(sbuf.toString()));
			}
			
			// verify if it is a bracket
			//opening
			else if (tokens[current] == '(')
				opStk.push(tokens[current]);
			//closing
			// however if it is a closing brace we need to solve the entire inner expression
			else if (tokens[current] == ')')
			{
				while (opStk.top() != '(')
					 doOperation();
				opStk.pop();
			}
			// verify if it is an operator 
			else {
				char op = tokens[current];
				// condition to be unary '-'
					if (isUnaryMinus(current,tokens)){
						op = 'U';
					}
					if (op == '=' || op == '!'){
						if (tokens[current] == '!' && tokens[current+1] == '='){
							current += 2;
							op = 'N';
						}
						if (tokens[current] == '=' && tokens[current+1] == '='){
							current += 2;
							op = 'E';
						}	
					}
					repeatOps(op);
					opStk.push(op);	
			}
			current++;
		}
		return valStk.top();
	}
	public static boolean isUnaryMinus(int current, char[] tokens){
		return (tokens[current] == '-' &&((current == 0)|| (!isNumber(tokens[current-1]) && (tokens[current-1] != '!') && (tokens[current-1] != ' '))|| (!isNumber(tokens[current-2]) && (tokens[current-2] != '!') && (tokens[current-2] != ' ') && (tokens[current-1] == ' '))));
		
	}
}