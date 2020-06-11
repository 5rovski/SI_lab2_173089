import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    User user = new User("nikola", "password123", "nikola@finki.mk");
    SILab2 test = new SILab2();
    List<String> allUsers = new ArrayList<String>();

    @Test
    void everyPath() {
        allUsers.add("kiko");
        allUsers.add("petko");
        allUsers.add("stanko");

        //A-K
        //user == null
        assertFalse(test.function(null, allUsers));

        //A-B-K
        //user.getUsername == null (ostanatite parametri se bilo kakvi)
        assertFalse(test.function(new User(null, "bilosto", "nikola@finki.mk"), allUsers));

        //A-B-C-D1-D2-E-G-D3-D2-I-K
        //user.getEmail() ne sodrzi ni '@' ni '.'
        assertFalse(test.function(new User("ignasio", "pass", "ignasiofinkimk"), allUsers));

        //A-B-C-D1-D2-E-F-G-D3-D2-I-K
        //user.getEmail() ima samo '@', no ne i '.'
        assertFalse(test.function(new User("ignasio", "pass", "ignasio@finkimk"), allUsers));

        //A-B-C-D1-D2-E-G-H-D3-D2-I-K
        //user.getEmail() ima samo '.', no ne i '@'
        assertFalse(test.function(new User("ignasio", "pass", "ignasiofinki.mk"), allUsers));

        //A-B-C-D1-D2-E-F-G-D3-D2-E-G-H-D3-D2-I-J
        //edno od scenarijata koga user.getEmail() e validen email
        assertTrue(test.function(user, allUsers));
    }

    @Test
    void everyBranch(){
        allUsers.add("kiko");
        allUsers.add("petko");
        allUsers.add("stanko");

        //A-K
        //user == null
        assertFalse(test.function(null, allUsers));

        //A-B, B-C, C-D1, D1-D2, D2-E, E-F, F-G, G-H, G-D3, H-D3, E-G, D3-D2, D2-I, I-J
        //user.getUsername() == nikola, user.getEmail() == nikola@finki.mk, AllUsers da ne sodrzi "nikola"
        assertTrue(test.function(user, allUsers));

        //B-K
        //user.getUsername() == null (ostanatite parametri se bilo sto)
        assertFalse(test.function(new User(null, "bilosto", "nikola@finki.mk"), allUsers));

        //I-K
        //user.getUsername() == nikola, user.getEmail == nikola@finki, AllUsers da ne go sodrzi "nikola"
        assertFalse(test.function(new User("nikola", "bilosto", "nikola@finkimk"),allUsers));

    }
}