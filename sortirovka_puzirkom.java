//Реализуйте алгоритм сортировки пузырьком числового массива, 
//результат после каждой итерации запишите в лог-файл.

package DZ2;
import java.io.FileWriter;
import java.util.Arrays; //Для перевода int[] array в string

public class sortirovka_puzirkom {
    public static void main(String[] args) {
        int[] array = {2, 8, 5, 11, 54, 3, 1}; 
        bubbleSort(array);           
        try(FileWriter writer = new FileWriter("sortBubble.txt", false)) 
        {
        // запись всей строки
            String text = Arrays.toString(array); // преобразование из int в string
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.flush();//Очищаем буфер потока
            writer.close(); // Обязательно закрываем
        }
        catch(Exception ex){ 
            System.out.println(ex.getMessage());
        } 
    }
    public static void bubbleSort(int[] array) { // сортировка пузырьком
        int temp;                                               
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length- i - 1; j++) {         
                if (array[j] > array[j + 1]) {                  
                    temp = array[j];                            
                    array[j] = array[j + 1];                   
                    array[j + 1] = temp;
                }
            }
        }
    }
}
    