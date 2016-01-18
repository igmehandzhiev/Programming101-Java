package week1;

public class week1 {
	boolean isOdd(int n){
		if(n%2==0)return false;
		else return true;
	}
	
	boolean isPrime(int n){
		int i=0;
		boolean result=true;
		for(i=0;i<n/2;i++){
			if(i%2==0)return false;
		}
		return result;
	}

	int min(int array[]){
		int i=0;
		int min=array[0];
		for(i=1;i<array.length;i++){
			if(min>array[i])min=array[i];
		}
		return min;
	}
	double kthMin(int k,int[] array){
		int i=0;
		int j=0;
		int []ArrayOfMins = new int[k];
		for(i=0;i<ArrayOfMins.length;i++){
			ArrayOfMins[i]=array[i];
		}
		for(i=0;i<ArrayOfMins.length;i++){
			for(j=0;j<array.length;j++){
				if(ArrayOfMins[i]>array[j]){
					ArrayOfMins[i]=array[j];
				}
			}
		}
		return ArrayOfMins[k-1];
	}
	double getAverage(int[] array){
		int i=0;
		int Sum=0;
		for(i=0;i<array.length;i++){
			Sum=Sum + array[i];
		}
		return Sum/array.length;
	}
	static long factoriel(long n){
		int i=0;
		int result=1;
		for(i=1;i<=n;i++){
			result=result*i;
		}
		return result;
	}
	
	static long doubleFactoriel(long n){
		return factoriel(factoriel(n));
	}
	
	static long kthFac(int k,int n){
		int i=0;
		long result=1;
		for(i=0;i<k;i++){
			result=result*factoriel(n);
		}
		return result;
	}
	static long getGreatestCommonDivisor(long x,long y){
		long remainder=1;
		do{
			if(x>y) {
				remainder=x%y;
				if(remainder==0)return y;
				x=remainder;
			}
			else {
				remainder=y%x;
				if(remainder==0)return x;
				y=remainder;				
			}
			
		}while(true);
		
	}
	
	static long getSmallestMultiple(int upperBound){
		int i=0;
		long lowestCommonMultiple;
		int[] array = new int[upperBound];
		for(i=0;i<upperBound;i++){
			array[i]=i+1;
		}
		lowestCommonMultiple=array[upperBound-1];
		for(i=upperBound-2;i>2;i--){
			lowestCommonMultiple=((i*lowestCommonMultiple)/getGreatestCommonDivisor(i,lowestCommonMultiple));
		}
		
		return lowestCommonMultiple;
	}
		
	static long getLargestPalindrome(long N){
		int countDigits=0;
		int i=0;
		long M=N;
		while(N!=0){
			countDigits++;
			N=N/10;
		}
		long []array = new long[countDigits];
		
		for(i=countDigits-1;i>=0;i--){
			array[i]=M%10;
			M=M/10;
		}
		long []palindrome = new long[countDigits];
		for(i=countDigits-1;i>=0;i--){
			if(i>countDigits/2){
				if((array[i]-array[countDigits-i])>=0){
					palindrome[i]=array[i]-(array[i]-array[countDigits-i-1]);
				}
				else{
					palindrome[i]=array[i]+(array[i]-array[countDigits-i-1]);
				}
			}
			else{
				palindrome[i]=array[i];
			}
		}
		long result=0;
		for(i=0;i<countDigits;i++){
			if(palindrome[i]!=0){
				result=result+palindrome[i]*pow(10,i);
			}
			else{
				result=result+pow(10,i);
			}
		}
		return result;
	}
	
	int[] histogram(short[][] image){
		int []result = new int [image.length];
		int i=0;
		int j=0;
		
		for(i=0;i<result.length;i++){
			result[i]=0;
		}
		
		for(i=0;i<image.length;i++){
			for(j=0;j<image.length;i++){
				if(image[i][j]==j){
					result[j]++;
				}
			}
		}
		
		return result;
		
	}
	
	public static long pow(int a,int b){
		int result=1;
		while(b>0){
			if(b%2==0){
				b=b/2;
				a=a*a;
			}
			else{
				result=result*a;
				b--;
			}
		}
		return result;
	}


	static int getOddOccurrence(int[] array){
	int i=0;
	int j=0;
	int count=0;
	int oddOccurence=0;
		for(i=0;i<array.length;i++){
			for(j=0;j<array.length;j++){
				if(array[i]==array[j])count++;
			}
			if(count%2!=0){
				oddOccurence=array[i];
				break;
			}
		}
		return oddOccurence;
		
	}
	
	
	
    public static int heapSize;
    public static int LEFT(int i)
    {
        //returns left index of a zero index based array
        return 2*i+1;
    }

    public static int RIGHT(int i)
    {
        //returns right index of a zero based array
        return 2*i+2;
    }


    public static void BUILD_MAX_HEAP(int A[])
    {
        heapSize = A.length;//heap size initialised
        for(int i=A.length/2; i>=0;i--)//since n/2, n/2+1 ... are leaves we can start from n/2 step downwards
        {
            //call MAX_HEAPIFY on each root node starting from n/2
            MAX_HEAPIFY(A, i);
        }
    }


    public static void MAX_HEAPIFY(int A[],int i)
    {
        int l=LEFT(i);//the left element's index which is 2*i+1 (for zero based indexed array)
        int r=RIGHT(i);//right index = 2*i+2;
        int largestElementIndex = -1;//index can't be negative so initialise largest index , it will be used later
        //heapSize is the current size of the heap being worked upon
        //check if left index lies within the heap.
        //if element at left index is greater than root(A[i]) element, max heap property is violated
        //copy the index of violated element in largestElementIndex
        if(l<heapSize && A[l]>A[i]){
            largestElementIndex = l;
        }
        else //if max heap property is not violated copy the root's index in largestElementIndex
        {
            largestElementIndex=i;
        }
        //check to see the right sub tree for max heap property violation
        //here the largestElementIndex is calculated from previous step
        if(r<heapSize && A[r]>A[largestElementIndex])
        {
            largestElementIndex = r;
        }
        //if root doesn't has the largest index then swap the largest element with root element

        if(largestElementIndex!=i)
        {
            int temp = A[i];
            A[i]=A[largestElementIndex];
            A[largestElementIndex]=temp;
            //after swap, recursively call the MAX_HEAPIFY on the largest index(root element)
            MAX_HEAPIFY(A, largestElementIndex);
        }
    }

    public static void HEAP_SORT(int A[])
    {
        //max heap is built with heapSize initialised
        BUILD_MAX_HEAP(A);
        //starting from end loop through entire array
        for(int i=A.length-1;i>=0;i--)
        {
            //since heap is already heapified and maintains max heap property
            //the first element of the array is root of max heap
            //swap it with the extreme element of the array i.e. setting the largest element to the end of array
            int temp = A[0];
            A[0]=A[i];
            A[i]=temp;
            //reduce the heap window by 1
            heapSize  = heapSize-1;
            //call max heapify on the reduced heap
            MAX_HEAPIFY(A,0);
        }
    }
    
    /*static int[] sortArray(int []array){
    	int i=0;
    	int j=0;
    	int temp;
    	int max=array[0];
    	for(i=0;i<array.length;i++){
    		for(j=i;j<array.length;j++){
    			if(max<array[j]){
    				temp=max;
    				max=array[j];
    				array[j]=temp;
    			}
    			if(i+1==array.length)break;
    			else max=array[i+1];
    			array[i]=max;

    		}
    	}
    	return array;
    }*/
	static long maximalScalarProduct(int []a,int []b){
		HEAP_SORT(a);
		HEAP_SORT(b);
		//a=sortArray(a);
		//b=sortArray(b);
		int result=0;
		int i=0;
		for(i=0;i<a.length;i++){
			result=result + a[i]*b[i];
		}
		return result;
	}
	
	static int maxSpan(int[] numbers){
		int maxSpan=0;
		int span=0;
		int i=0;
		int j=0;
		for(i=0;i<numbers.length;i++){
			for(j=0;j<numbers.length;j++){
				if(numbers[i]==numbers[j]){
					span=j;
				}
			}
			if(span>maxSpan)maxSpan=span;
		}
		return maxSpan;
	}
	
	static boolean canBalance(int[] numbers){
		int total=0;
		int sumLeft=0;
		int sumRigth=0;
		int i=0;
		int j=0;
		boolean flag=false;
		for(i=0;i<numbers.length;i++){
			total=total+numbers[i];
		}
		if(total%2!=0)return false;
		else{
			for(i=0;i<numbers.length;i++){
				sumLeft=sumLeft+numbers[i];
				for(j=i;j<numbers.length;j++){
					sumRigth=sumRigth+numbers[j];
				}
				if(sumLeft==sumRigth){
					flag=true;
				}
				sumLeft=0;
				sumRigth=0;
			}
		}
		return flag;
	}
	
	/*int[][] rescale(int[][] original, int newWidth, int newHeight){
		int i=0;
		int j=0;
		int [][]newPic = new int[newWidth][newHeight];
		for(i=0;i<newWidth)
		
	}
	*/
	static String reverseMe(String argument){
		String reverseArgument="";
		int i=0;
		for(i=argument.length()-1;i>=0;i--){
			reverseArgument = reverseArgument+argument.charAt(i);
		}
		return reverseArgument;
	}
	
	static long function(long []arr,long index){
		int i=0;
		long result=1;
		for(i=0;i<arr.length;i++){
			if(i!=index)result=result*arr[i];
		}
		return result;
	}
	static int firstIndex(String str,char c){
		int i=0;
		int firstIndex=-1;
		for(i=0;i<str.length();i++){
			if(str.charAt(i)==c){
				firstIndex=i;
				break;
			}
		}
		return firstIndex;
	}
	
	static String reverseEveryChar(String arg){
		String result="";
		int i=0;
		int j=0;
		for(i=0;i<arg.length();i++){
			if(arg.charAt(i)==' '){
				result=result+reverseMe(arg.substring(j,i));

				j=i;
				if(j==arg.lastIndexOf(' ')){
					result=result+reverseMe(arg.substring(j,arg.length()));
					break;
				}
				result=result + arg.charAt(i);
			}
		}
		
		return result;
	}
		
	//boolean isPalindrome(String argument){
	//	if(argument.substring(0,argument.length()))
	//}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(kthFac(2,3));
		System.out.println(doubleFactoriel(3));
		System.out.println(getSmallestMultiple(10));
		System.out.println(getLargestPalindrome(123467895 )+ "+");
		System.out.println(pow(2,5));
		int []array = { 1,2,2,1,3,4,3,4,4,6,5,6,5 };
		int []a = {1,2,3};
		int []b = {1,2,3,4,5};
		System.out.println("Maximal Scalar Product:" + maximalScalarProduct(a,b));
		System.out.println(getOddOccurrence(array));
		long[]c={0,2,3,0,5};
		System.out.println("Max Span is:" + maxSpan(a));
		System.out.println(canBalance(a));
		System.out.println(reverseMe("abcd"));
		System.out.println(function(c,0));
		System.out.println(reverseEveryChar("What is     this"));
		
	}

}