package dateTimeApis;

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

        ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(indiaTimeZone);
        System.out.println("zonedDateTime :"+zonedDateTime);
        System.out.println("zonedDateTime :"+zonedDateTime.withZoneSameInstant(berlinZone));


        LocalDateTime localDateTime = LocalDateTime.from(berlinTimeOffsetToUTC);
        System.out.println(localDateTime);




    }

}
