package fr.arolla;

import com.ibm.mainframe.WdkRefCustContainerRoot;
import com.ibm.mainframe.WdkRefCustInformations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 *
 */
public class RandomTravels implements Travels {

    private Random random = new Random();

    public Collection<Journey> all() {
        return Stream.generate(() -> {
            WdkRefCustContainerRoot instance = WdkRefCustContainerRoot.getInstance();
            Journey journey = new Journey();
            journey.setId(instance.all().stream().skip(random.nextInt(7)).findAny().map(WdkRefCustInformations::getField04).orElse("0"));
            journey.setType(Arrays.asList("1","2","3","4","5","6").stream().skip(random.nextInt(5)).findAny().orElse("2"));
            journey.setDate(LocalDateTime.now().minusHours(random.nextInt(10)).minusDays(random.nextInt(30)));
            return journey;
        }).peek(System.out::println)
          .limit(1000)
                .collect(toList());
    }
}
