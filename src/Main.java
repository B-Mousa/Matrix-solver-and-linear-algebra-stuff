import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. invert matrix");
        System.out.println("5. find the determinant of a matrix");
        System.out.println("6. display the transpose");
        System.out.println("0. Exit");
        int  s;
        do{
            System.out.print("Your choice: > ");
             s = sc.nextInt();

            if(s == 1){
                add();
            } else if (s == 2) {
                sc_mult();

            } else if (s == 3) {
                matric_mult();

            }else if (s == 4) {
                int n;
                Scanner sc1 = new Scanner(System.in);
                System.out.println("please inter the dimensions of your square matrix");
                n=sc.nextInt();
                double [][] arr = new double[n][n];
                System.out.println("please enter the matrix elements");
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        arr[i][j]=sc.nextInt();
                    }
                }
               double[][] d = MatrixInvertion.invert(arr);
                System.out.println("The inverse is: ");
                for (int i=0; i<n; ++i)
                {
                    for (int j=0; j<n; ++j)
                    {
                        d[i][j] = Math.round(d[i][j]*100)/100.0;
                        System.out.print(d[i][j]+"  ");
                    }
                    System.out.println();
                }

            } else if (s == 5) {
                int n;
                Scanner sc1 = new Scanner(System.in);
                System.out.println("please inter the dimensions of your square matrix");
                n=sc.nextInt();
                double [][] arr = new double[n][n];
                System.out.println("please enter the matrix elements");
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        arr[i][j]=sc.nextInt();
                    }
                }
                System.out.println(MatrixDeterminant.determinant(arr,n));

            } else if (s == 6) {
                transpose();
            } else if (s == 0) {
                break;

            }
        }while(s!=0);




    }
    public static void matric_mult(){
        int n1,m1;//number of rows and columns

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of first matrix: > ");
        n1=sc.nextInt();
        m1=sc.nextInt();
        double [][] arr = new double[n1][m1];
        //ask for the elements of the first matrix
        System.out.println("Enter first matrix:");
        for(int i=0;i<n1;i++){
            for(int j=0;j<m1;j++){
                arr[i][j]=sc.nextDouble();
            }
        }
        int n2,m2;//number of rows and columns
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter size of second matrix: > ");
        n2=sc.nextInt();
        m2=sc.nextInt();
        double [][] arr2 = new double[n2][m2];
        //ask for the elements of the first matrix
        System.out.println("Enter second matrix:");
        for(int i=0;i<n2;i++) {
            for (int j = 0; j < m2; j++) {
                arr2[i][j] = sc.nextDouble();
            }
        }
        double [][] result = new double[n1][m2];
        if(m1 == n2){// to multiply two matrices the number of columns  of the first matrix should be the same  number
            // of columns as the second matrix
            /*new matrix will have the number of rows as the first matrix(n1) and the number of columns as the secomde one(m2)
            (1) so the first for loop will go through the rows of the new matrix
            (2) the second for loop will go columns of the second one
            (3) the third will make sure not to do more operations than the number of columns of first or columns of the second
            */
            for(int i =0;i < n1;i++){
                for(int j =0; j<m2;j++){
                    for(int k =0; k<m1;k++){
                        result[i][j]+= arr[i][k]*arr2[k][j];

                    }
                }
            }
        }
        System.out.println("The result is:");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void add(){
        int n,m;
        Scanner sc = new Scanner(System.in);
        //taking the number of rows and columns of the first matrix
        System.out.print("Enter size of first matrix: > ");
        n=sc.nextInt();
        m=sc.nextInt();
        double [][] arr = new double[n][m];
        //taking the elements of the first matrix
        System.out.println("Enter first matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextDouble();
            }
        }
        int p,o;
        Scanner sc1 = new Scanner(System.in);
        //taking the number of rows and columns of the second  matrix
        System.out.print("Enter size of second matrix: > ");
        p=sc.nextInt();
        o=sc.nextInt();
        double [][] arr2 = new double[p][o];
        //taking the elements of the second matrix
        System.out.println("Enter second matrix:");
        for(int i=0;i<p;i++) {
            for (int j = 0; j < o; j++) {
                arr2[i][j] = sc.nextDouble();
            }
        }


        double c[][] = null;
        if(m == p && n == o) {//checking of the two matrices have the same size
            c  = new double[n][m];
            System.out.println("The result is:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    c[i][j] = arr[i][j] + arr2[i][j]; //very simple addition for corresponding elements of the two matrices
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{//حقهىفهىل شى ثققخق ةثسسشلث بخق فاث عسثق
            System.out.println("The operation cannot be performed (please enter matrices from the same size).");
        }
    }
    public static void sc_mult(){
        Scanner sc = new Scanner(System.in);
        int n,m;
        //taking the size of the matrix
        System.out.print("Enter size of matrix: > ");
        n=sc.nextInt();
        m=sc.nextInt();

        double [][] arr = new double[n][m];
        //taking the elemnts of the matrix
        System.out.println("Enter matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextDouble();
            }
        }
        // the mult proses
        System.out.print("Enter constant: > ");
        int s = sc.nextInt();
        System.out.println("The result is:");
        /*simple nested for loop to multiply the scalar with every element */
        for(int i=0 ; i<n; i++){
            for(int j =0; j<m;j++){
                arr[i][j]=arr[i][j]*s;
                System.out.print(arr[i][j]+"\s");
            }
            System.out.println();
        }
    }
    public static void sub(){
        int n,m;
        Scanner sc = new Scanner(System.in);
        //taking the number of rows and columns of the first matrix
        System.out.print("Enter size of first matrix: > ");
        n=sc.nextInt();
        m=sc.nextInt();
        double [][] arr = new double[n][m];
        //taking the elements of the first matrix
        System.out.println("Enter first matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextDouble();
            }
        }
        int p,o;
        Scanner sc1 = new Scanner(System.in);
        //taking the number of rows and columns of the second  matrix
        System.out.print("Enter size of second matrix: > ");
        p=sc.nextInt();
        o=sc.nextInt();
        double [][] arr2 = new double[p][o];
        //taking the elements of the second matrix
        System.out.println("Enter second matrix:");
        for(int i=0;i<p;i++) {
            for (int j = 0; j < o; j++) {
                arr2[i][j] = sc.nextDouble();
            }
        }


        double c[][] = null;
        if(m == p && n == o) {//checking of the two matrices have the same size
            c  = new double[n][m];
            System.out.println("The result is:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    c[i][j] = arr[i][j] - arr2[i][j]; //very simple subtraction for corresponding elements of the two matrices
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{//printing an error mesage to the user
            System.out.println("The operation cannot be performed (please enter matrices from the same size).");
        }
    }
    public static void transpose(){
        int i, j;
        System.out.println("Enter total rows and columns: ");
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int column = s.nextInt();
        int array[][] = new int[row][column];
        System.out.println("Enter matrix:");
        for(i = 0; i < row; i++)
        {
            for(j = 0; j < column; j++)
            {
                array[i][j] = s.nextInt();
                System.out.print("");
            }
        }
        System.out.println("The above matrix before Transpose is ");
        for(i = 0; i < row; i++)
        {
            for(j = 0; j < column; j++)
            {
                System.out.print(array[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println("The above matrix after transpose is ");
        for(i = 0; i < column; i++)
        {
            for(j = 0; j < row; j++)
            {
                System.out.print(array[j][i]+" ");
            }
            System.out.println(" ");
        }
    }
}