package Exceptions;

/*
Эта задачка совмещает тренировку по материалу предыдущих двух модулей – необходимо разобраться и написать
объект-ориентированный код и при этом коснуться свежих тем – исключений и логирования.

Дан набор классов, описывающих работу гипотетической почтовой системы.
Для начала рассмотрим код, описывающий все используемые сущности.

- У Sendable есть два наследника, объединенные следующим абстрактным классом:
public static abstract class AbstractSendable implements Sendable

- Первый класс описывает обычное письмо, в котором находится только текстовое сообщение.
public static class MailMessage extends AbstractSendable

- Второй класс описывает почтовую посылку:
public static class MailPackage extends AbstractSendable

- При этом сама посылка описывается следующим классом:
public static class Package

- Теперь рассмотрим классы, которые моделируют работу почтового сервиса:
public static interface MailService
public static class RealMailService implements MailService

Вам необходимо описать набор классов, каждый из которых является MailService:

1) UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать
почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц, а затем,
в конце концов, передает получившийся объект непосредственно экземпляру RealMailService. У UntrustworthyMailWorker
должен быть конструктор от массива MailService (результат вызова processMail первого элемента массива передается на
вход processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний
экземпляр RealMailService, он не приходит масивом в конструкторе и не настраивается извне класса.

2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется от
экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса
MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения
полей почты):
2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с
уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}

3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе
переменную int – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен присутствовать
метод getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал. Воровство происходит
следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же, только с нулевой ценностью и
содержимым посылки "stones instead of {content}".

4) Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состоящую из
камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения вы должны
объявить самостоятельно в виде непроверяемых исключений.

Все классы должны быть определены как публичные и статические, так как в процессе проверки ваш код будет подставлен
во внешний класс, который занимается тестированием и проверкой структуры. Для удобства во внешнем классе объявлено
несколько удобных констант и импортировано все содержимое пакета java.util.logging. Для определения, посылкой или
письмом является Sendable объект воспользуйтесь оператором instanceof.


public static final String AUSTIN_POWERS = "Austin Powers";
public static final String WEAPONS = "weapons";
public static final String BANNED_SUBSTANCE = "banned substance";
*/


import java.util.logging.Level;
import java.util.logging.*;

public class JavaCore_4_3_7 {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";



    public static class UntrustworthyMailWorker implements MailService {


        private final MailService[] mailServices;
        private final RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }

        public Sendable processMail(Sendable mail) {
            Sendable processed = mail;
            for (int i = 0; i < mailServices.length; i++) {
                processed = mailServices[i].processMail(processed);
            }
            return getRealMailService().processMail(processed);
        }
    }

    public static class Spy implements MailService {

        private final Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage mailMessage = (MailMessage) mail;
                if (mailMessage.from.equals("Austin Powers") || mailMessage.to.equals("Austin Powers")) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", new String[]{mailMessage.getFrom(), mailMessage.getTo(), mailMessage.getMessage()});
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new String[]{mailMessage.getFrom(), mailMessage.getTo()});
                }
            }
            return mail;
        }

    }

    public static class Thief implements MailService {

        int minThiefPrice;
        int stolenValue;

        public Thief(int minThiefPrice) {
            this.minThiefPrice = minThiefPrice;
        }

        public Package thief(Package aPackage) {
            stolenValue += aPackage.getPrice();

            return new Package("stones instead of " + aPackage.getContent(), 0);
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                Package aPackage = mailPackage.getContent();
                if (aPackage.getPrice() >= minThiefPrice) {
                    Package newPackage = thief(aPackage);
                    MailPackage newMailPackage = new MailPackage(mailPackage.getFrom(), mailPackage.getTo(), newPackage);
                    return newMailPackage;
                }
            }
            return mail;
        }
    }

    public static class Inspector implements MailService {


        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                Package aPackage = mailPackage.getContent();
                if (aPackage.getContent().contains("weapons") || aPackage.getContent().contains("banned substance")) {
                    throw new IllegalPackageException("Ахтунг");
                }
                if (aPackage.getContent().contains("stones")) {
                    throw new StolenPackageException("Ахтунг");
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {

        public IllegalPackageException(String message) {
            super(message);
        }
    }

    public static class StolenPackageException extends RuntimeException {

        public StolenPackageException(String message) {
            super(message);
        }
    }


    public static void main(String[] args) {
        Logger logger = Logger.getLogger(JavaCore_4_3_7.class.getName());
        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(new MailService[]{spy, thief, inspector});
        AbstractSendable[] correspondence = {
                new MailMessage("Oxxxymiron", "Гнойный", " Я здесь чисто по фану, поглумиться над слабым\n" +
                        "Ты же вылез из мамы под мой дисс на Бабана...."),
                new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                        "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                new MailMessage("Жириновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                new MailPackage("берег", "море", new Package("ВВЖ", 32)),
                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("ракетный двигатель ", 2500000)),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("stones ", 1000)),
                new MailPackage("Китай", "КНДР", new Package("banned substance ", 10000)),
                new MailPackage(AUSTIN_POWERS, "Жопа запрещенная группировка", new Package("tiny bomb", 9000)),
                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),

        };

        for (AbstractSendable p : correspondence) {
            try {
                print("До:  ", p);
                Sendable sendable = worker.processMail(p);
                print("После:  ", sendable);
            } catch (StolenPackageException | IllegalPackageException e) {
                logger.log(Level.WARNING, "из: " + p.getFrom() + " куда: " + p.getTo() + " Содержимое: "
                        + (p instanceof MailMessage ? ((MailMessage) p).getMessage() : ((MailPackage) p).getContent().getContent()
                        + " Цена=" + ((MailPackage) p).getContent().getPrice()) + " Exceptions: " + e);
            }
        }
    }

    public static void print(String prefix, Sendable p) {
        System.out.println(prefix + "из: " + p.getFrom() + " куда: " + p.getTo() + " Содержимое: "
                + (p instanceof MailMessage ? ((MailMessage) p).getMessage() : ((MailPackage) p).getContent().getContent()
                + " Цена=" + ((MailPackage) p).getContent().getPrice()));
    }

    /*
        Интерфейс: сущность, которую можно отправить по почте.
        У такой сущности можно получить от кого и кому направляется письмо.
    */
    public interface Sendable {
        String getFrom();
        String getTo();

    }

    /*
       Абстрактный класс,который позволяет абстрагировать логику хранения
       источника и получателя письма в соответствующих полях класса.
    */
    public static abstract class AbstractSendable implements Sendable {
        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }


        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AbstractSendable that = (AbstractSendable) o;
            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;
            return true;
        }
    }

    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {
        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            MailMessage that = (MailMessage) o;
            if (message != null ? !message.equals(that.message) : that.message != null) return false;
            return true;
        }
    }

    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            MailPackage that = (MailPackage) o;
            if (!content.equals(that.content)) return false;
            return true;
        }
    }

    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;
            return true;
        }
    }
    /*
    Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
    */
    public interface MailService {
        Sendable processMail(Sendable mail);
    }
    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }
}