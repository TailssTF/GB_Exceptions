public class Person {
    String surname;
    String name;
    String middleName;
    String birthDate;
    int phone;
    char gender;

    public Person(String surname, String name, String middleName, String birthDate, String phone, String gender) {
        try {
            validateData(surname, name, middleName, birthDate, phone, gender);

            this.surname = surname;
            this.name = name;
            this.middleName = middleName;
            this.birthDate = birthDate;
            this.phone = Integer.parseInt(phone);
            this.gender = gender.charAt(0);
        } catch (MyInputException e) {
            e.printStackTrace();
        }
    }

    public Person(String[] str) {
        try {
            validateData(str[0], str[1], str[2], str[3], str[4], str[5]);

            this.surname = str[0];
            this.name = str[1];
            this.middleName = str[2];
            this.birthDate = str[3];
            this.phone = Integer.parseInt(str[4]);
            this.gender = str[5].charAt(0);
        } catch (MyInputException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "<" + surname + ">" + " <" + name + ">" + " <" + middleName + ">" + " <" + birthDate + ">" + " <" + phone + ">" + " <" + gender + ">\n";
    }

    private void validateData(String surname, String name, String middlename, String birthDate, String phone, String gender) throws MyInputException {
        if (surname.isEmpty()) throw new MyInputException("Некорректная фамилия");
        if (name.isEmpty()) throw new MyInputException("Некорректное имя");
        if (middlename.isEmpty()) throw new MyInputException("Некорректное отчество");
        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) throw new MyInputException("Некорректная дата рождения");
        if (!phone.matches("\\d+")) throw new MyInputException("Некорректный номер телефона");
        if (gender.charAt(0) != 'm' && gender.charAt(0) != 'f') throw new MyInputException("Некорректный пол");;
    }
}
