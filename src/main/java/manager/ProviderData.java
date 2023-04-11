package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> loginModelDto(){
        List<Object[]> list = new ArrayList<>();
        list.add( new Object[]{ User.builder().
               email("tulip@gmail.com").
                password("Kanareyka17$").build()
        });

        list.add( new Object[]{ User.builder().
                email("tulip@gmail.com").
                password("Kanareyka17$").build()
        });

        list.add( new Object[]{ User.builder().
                email("tulip@gmail.com").
                password("Kanareyka17$").build()

        });

               return list.iterator();


    }
}