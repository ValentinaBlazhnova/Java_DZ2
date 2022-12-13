// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

package DZ2;

public class zapros_StringBuilder{
    public static void main(String[] args) {
        String requesSQL = "select * from students where ";
        String jsonFilter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String result = new StringBuilder(requesSQL).append(ParseFilter(jsonFilter)).toString(); //переменную запроса SQL заполняем отфильтрованными данными json: .toString() используется для преобразования к типу string
        System.out.println(result);
    }

    public static String ParseFilter(String filter) {
        String[] data = filter.substring(1, filter.length()-1).split(", "); //substring возвращает новую строку, которая является подстрокой данной строки
        StringBuilder where = new StringBuilder();
        boolean first = true;
        for (String elem: data)  {
            String[] value = elem.split(":");
            if(!value[1].equals("\"null\"")) { //equals - cравнение объектов; оператор ! - логическое «НЕ» (NOT))
                if(first)
                    first = false;
                else
                    where.append(" , ");
                where.append(value[0].substring(1, value[0].length() - 1));
                where.append(" = '");
                where.append(value[1].substring(1, value[1].length() - 1));
                where.append("'");
            }
        }
        return where.toString();
    }
}
    
