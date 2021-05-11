package dateTimeApis;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import java.time.*;

public class dateTimeApis {

    public static void main(String[] args){

        LocalDateTime indiaTime = LocalDateTime.now();
        System.out.println("indiaTime :"+indiaTime);

        ZoneId indiaTimeZone = ZoneId.systemDefault();
        System.out.println("indiaTimeZone Timezone :"+indiaTimeZone);

        ZoneId berlinZone = ZoneId.of("Europe/Berlin");
        LocalDateTime berlinTime = LocalDateTime.now(berlinZone);
        System.out.println("Berlin :"+ berlinTime);

        ZoneOffset berlinOffset = berlinZone.getRules().getOffset(indiaTime);
        System.out.println("Berlin Timezone offset : "+berlinOffset);

        ZoneOffset indiaOffset = indiaTimeZone.getRules().getOffset(indiaTime);
        System.out.println("india TimeZone offset : "+indiaOffset);

        OffsetDateTime indiaTimeOffsetToUTC = OffsetDateTime.of(indiaTime, indiaOffset);
        System.out.println("India offsetDateTime : "+indiaTimeOffsetToUTC);

        OffsetDateTime berlinTimeOffsetToUTC = OffsetDateTime.of(berlinTime, berlinOffset);
        System.out.println("Berlin offsetDateTime : "+berlinTimeOffsetToUTC);

        System.out.println("atZoneSameInstant :"+berlinTimeOffsetToUTC.atZoneSameInstant(indiaTimeZone));

        // what the time for a specific zone or offset is in our own timezone
        ZonedDateTime indiaZonedDateTime = LocalDateTime.now().atZone(indiaTimeZone);
        System.out.println("India zonedDateTime :"+indiaZonedDateTime);
        ZonedDateTime berlinZonedDateTime1 = indiaZonedDateTime.withZoneSameInstant(berlinZone);
        System.out.println("Berlin zonedDateTime :"+ berlinZonedDateTime1);


        ConversionService conversionService = new DefaultConversionService();
        LocalDateTime localDateTime1 = conversionService.convert(berlinZonedDateTime1, LocalDateTime.class);
        System.out.println("localDateTime1 :"+localDateTime1);


        LocalDateTime localDateTime = LocalDateTime.from(berlinTimeOffsetToUTC);
        System.out.println(localDateTime);




    }

}
