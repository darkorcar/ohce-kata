import com.katas.ohce.*
import spock.lang.Specification

class OhceAcceptanceTest extends Specification {

    private Writer writerMock = Mock(Writer)

    private Reader readerMock = Mock(Reader)

    private TimeProvider timeProvider = Stub(TimeProvider)

    private OhceApp ohceApp

    void setup() {
        ohceApp = new OhceApp(
                new Ohce(
                    new DayGreeter(timeProvider, writerMock),
                    new ReverseEcho(writerMock)),
                readerMock
        )
    }

    /*
    When you start oche, it greets you differently depending on the current time,
    but only in Spanish:
        Between 20 and 6 hours, ohce will greet you saying: ¡Buenas noches < your name >!
        Between 6 and 12 hours, ohce will greet you saying: ¡Buenos días < your name >!
        Between 12 and 20 hours, ohce will greet you saying: ¡Buenas tardes < your name >!
     */

    def "should greet name depending on the current time"() {
        given:
        timeProvider.hour() >> hour
        readerMock.hasNext() >> false

        String name = "darko"

        when:
        ohceApp.greet(name)

        then:
        1 * writerMock.print(greeting)

        where:
        hour || greeting
        21   || "¡Buenas noches darko!"
        7    || "¡Buenos dias darko!"
        13   || "¡Buenas tardes darko!"
    }

    /*
    When you introduce a palindrome, ohce likes it
    and after reverse-echoing it, it adds ¡Bonita palabra!
     */

    def "should echo inputs and reverse input and like it if palindrom"() {
        given:
        readerMock.hasNext() >>> [true,false]
        readerMock.nextLine() >> 'oto'

        when:
        ohceApp.processInputs()

        then:
        1 * writerMock.print("oto")
        1 * writerMock.print("¡Bonita palabra!")
    }

    /*
    ohce knows when to stop, you just have to write Stop!
    and it'll answer Adios < your name > and end.
     */

    def "should answer Adios on Stop! and exit"() {
        given:
        String name = "Pedro"

        and:
        ohceApp.greet(name)

        and:
        readerMock.hasNext() >> true
        readerMock.nextLine() >> 'Stop!'

        when:
        ohceApp.processInputs()

        then:
        1 * writerMock.print("Adios Pedro")
    }
}
