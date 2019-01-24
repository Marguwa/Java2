package homeWork2;

public class Main {

    public static void main(String[] args) {

        String [][] arr = new String [][]{
                {"0", "0", "0", "0"},
                {"1", "1", "1", "o"},
                {"2", "2", "2", "2"},
                {"3", "3", "2", "3"}
        };

        try {
            int result;
            result = convert(arr);
            System.out.println(result);
        }
        catch (MyArraySizeException e) {
              System.out.println("Размерность массива некорректна!");

        } catch (MyArrayDataException e) {
              System.out.println("Некорректное значение ячейки: " + ((e.i) +1) + "x" + ((e.j) + 1));
        }

    }


    public static int convert(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }

            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return sum;
    }

    private static class MyArraySizeException extends Exception {
    }
}
