package Library;

import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class PersonCRUD {
    
        ArrayList <Person> personList = new ArrayList();

        PersonCRUD() {
            personList = new ArrayList();
        }

        public void personCreate(Person person) {

            personList.add(person);
        }

        public Person personRetrieve(Person person) {

            for (Person p : personList) {
                    if (p.equals(person)) return p;
            }
            return null;
        }

        public void personUpdate (Person person, Person newPerson) {

            Person tempPerson = personRetrieve(person);
                if (tempPerson != null) {
                    tempPerson.setFname(newPerson.getFname());
                    tempPerson.setLname(newPerson.getLname());
                    tempPerson.setAddress(newPerson.getAddress());
                    tempPerson.setId(newPerson.getId());
                }
        }      

        public void personDelete(Person person) {

            boolean found = false;
                for (int i = 0; i < personList.size() && found !=true; i++) {
                    found = personList.get(i).equals(person);
                        if (found) {
                            personList.remove(i);
                            return;
                        }
                }
        }

    @Override
        public String toString(){
            String str = "";
                for (Person person: personList){
                    str += (person.getFname() + ";" + person.getLname() + ";" + person.getAddress() + ";" + person.getId() + "\n");
                }
                return str;
        }


}
