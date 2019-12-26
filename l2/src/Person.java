public class Person {
  
  final String name, lastName, birthDate;
  
  public void print() {
    System.out.print(this.name + " " + this.lastName + " " + this.birthDate + "\n");
  }
  
  Person(String name, String lastName, String birthDate) {
    this.name = name;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }
  

  @Override
  public final boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Person))
      return false;
    Person other = (Person) obj;
    if (birthDate == null) {
      if (other.birthDate != null)
        return false;
    } else if (!birthDate.equals(other.birthDate))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
  

}