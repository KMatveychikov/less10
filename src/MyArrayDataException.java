public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String cellValue, int rowIndex, int colIndex){
        super(String.format("Invalid value '%s' in cell [%d][%d]",cellValue,rowIndex,colIndex));

    }

}
