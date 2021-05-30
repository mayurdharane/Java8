package dateTimeApis;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class dateTimeApis {

    public static void main(String[] args){

        LocalDateTime indiaTime = LocalDateTime.now();
        System.out.println("indiaTime :"+indiaTime);

        ZoneId indiaTimeZone = ZoneId.systemDefault();
        System.out.println("indiaTimeZone Timezone :"+indiaTimeZone);

        ZoneId berlinZone = ZoneId.of("Europe/Berlin");
        LocalDateTime berlinTime = LocalDateTime.now(berlinZone);
        System.out.println("Berlin :"+ berlinTime);

//        ZoneOffset berlinOffset = berlinZone.getRules().getOffset(indiaTime);
//        System.out.println("Berlin Timezone offset : "+berlinOffset);
//
//        ZoneOffset indiaOffset = indiaTimeZone.getRules().getOffset(indiaTime);
//        System.out.println("india TimeZone offset : "+indiaOffset);

//        OffsetDateTime indiaTimeOffsetToUTC = OffsetDateTime.of(indiaTime, indiaOffset);
//        System.out.println("India offsetDateTime : "+indiaTimeOffsetToUTC);
//
//        OffsetDateTime berlinTimeOffsetToUTC = OffsetDateTime.of(berlinTime, berlinOffset);
//        System.out.println("Berlin offsetDateTime : "+berlinTimeOffsetToUTC);
//
//        System.out.println("atZoneSameInstant :"+berlinTimeOffsetToUTC.atZoneSameInstant(indiaTimeZone));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime xmldateTime = LocalDateTime.parse("2021-05-20T02:30:30", formatter);
        System.out.println("xmldateTime :"+xmldateTime);

        // what the time for a specific zone or offset is in our own timezone
        ZonedDateTime indiaZonedDateTime = xmldateTime.atZone(indiaTimeZone); //LocalDateTime.now()
        System.out.println("India zonedDateTime :"+indiaZonedDateTime);
        System.out.println("India dateTime :"+indiaZonedDateTime.toLocalDateTime());
        ZonedDateTime berlinZonedDateTime1 = indiaZonedDateTime.withZoneSameInstant(berlinZone);
        System.out.println("Berlin zonedDateTime :"+ berlinZonedDateTime1);
        System.out.println("Berlin dateTime :"+ berlinZonedDateTime1.toLocalDateTime());


//        ConversionService conversionService = new DefaultConversionService();
//        LocalDateTime localDateTime1 = conversionService.convert(berlinZonedDateTime1, LocalDateTime.class);
//        System.out.println("localDateTime1 :"+localDateTime1);
//
//        System.out.println("--------------");
//        LocalDateTime oldDateTime = LocalDateTime.parse("2021-12-05T17:31:00");
//        ZoneId oldZone = ZoneId.of("America/Chicago");
//        System.out.println("oldDateTime : "+oldDateTime);
//        ZoneId newZone = ZoneId.of("America/New_York");
//        LocalDateTime newDateTime = oldDateTime.atZone(oldZone)
//                .withZoneSameInstant(newZone)
//                .toLocalDateTime();
//        System.out.println(newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//        System.out.println("--------------");
//        System.out.println("indiaTime : "+indiaTime);
//        LocalDateTime toLocalDateTime = indiaTime.atZone(indiaTimeZone)
//                .withZoneSameInstant(oldZone)
//                .toLocalDateTime();
//
//        System.out.println("Ind toLocalDateTime in Berlin : "+toLocalDateTime);
//
//        System.out.println("***********************************");
//
//        System.out.println("indiaTime : "+indiaTime);





    }

}
