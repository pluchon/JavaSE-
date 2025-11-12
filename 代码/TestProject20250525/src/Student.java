public class Student {
        public int age;
        public int high;
        public String name;

        public Student(){
            this.age = 18;
            this.high = 180;
            this.name = "zlh";
            //this.print();
        }

        public Student (int age,int high,String name ){
            this.age = age;
            this.high = high;
            this.name = name;
            //this.print();
        }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", high=" + high +
                ", name='" + name + '\'' +
                '}';
    }
//public void setStudent(Student this,int age,int high,String name){
        //    this.age = age;
        //    this.high = high;
        //    this.name = name;
        //    this.print();
        //}

        //public void print() {
        //System.out.println(age + " " + high + " " + name);
        //}
}