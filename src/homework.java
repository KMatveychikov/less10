public class homework {

    private static String[][] correct = new  String[][]{
            {"1","2","3","4"},
            {"5","6","7","8"},
            {"1","2","3","4"},
            {"9","10","11","12"},
    };
    private static String[][] incorrectData = new  String[][]{
            {"1","2","3","4"},
            {"5","6","7","8"},
            {"1","2","3","4"},
            {"9","10","a","12"},
    };
    private static String[][] incorrectSize = new  String[][]{
            {"1","2","3","4"},
            {"5","6","7","8"},
            {"1","2","3","4"},
            {"9","10","11","12","13"},

    };

    public static void main(String[] args) {
        try {
            int result = sumArray(incorrectData);
            System.out.println("Сумма массива "+ result);
        } catch (MyArraySizeException e){
            System.out.println("Некорректный размер массива");
        }catch (MyArrayDataException e){
            System.out.println("Некорректные данные в массиве");
            System.err.println(e.getMessage());
        }

    }

    private static void checkSize(String[][] arr){
        if (arr.length != 4){
            throw new MyArraySizeException();
        }
        for (String[] row : arr) {
            if(row.length != 4){
                throw new MyArraySizeException();

            }
        }
    }

    private static int sumArray(String[][] arr){
        checkSize(arr);

        int sum = 0;

        for (int rowIndex = 0; rowIndex < arr.length; rowIndex++) {
            String[] row = arr[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                String value = row[colIndex];
                try{
                    sum += Integer.parseInt(value);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(value,rowIndex,colIndex);
                }

            }

        } return sum;



    }
}
