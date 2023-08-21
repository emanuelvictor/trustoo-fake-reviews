package br.com.lojasgresele.reviews;

import br.com.lojasgresele.reviews.model.Review;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static br.com.lojasgresele.reviews.GPT3ReviewGenerator.COUNT_OF_REVIEWS;

public class Main {

    static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(1);
    static final List<String> RAW_EMAILS_AND_NAMES = Arrays.asList(new String[]{"ana_silva@hotmail.com; Ana Silva", "joao.oliveira@gmail.com; João Oliveira", "maria_rodrigues@hotmail.com; Maria Rodrigues", "pedro.almeida123@hotmail.com; Pedro Almeida", "isabella.santos@gmail.com; Isabella Santos", "lucas.martins@hotmail.com; Lucas Martins", "julia_faria456@gmail.com; Júlia Faria", "gabriel.gomes@hotmail.com; Gabriel Gomes", "laura_pereira789@gmail.com; Laura Pereira", "enzo.costa@hotmail.com; Enzo Costa", "carolina_ferreira@hotmail.com; Carolina Ferreira", "davi_azevedo@gmail.com; Davi Azevedo", "sophia.machado@hotmail.com; Sophia Machado", "miguel.barros789@gmail.com; Miguel Barros", "alice_ramos@hotmail.com; Alice Ramos", "guilherme_correia@gmail.com; Guilherme Correia", "beatriz_nascimento123@hotmail.com; Beatriz Nascimento", "gustavo.cardoso456@gmail.com; Gustavo Cardoso", "manuela_melo@hotmail.com; Manuela Melo", "rafaela.ferreira@gmail.com; Rafaela Ferreira", "felipe_castro123@hotmail.com; Felipe Castro", "emanuel_silveira@gmail.com; Emanuel Silveira", "leticia.carvalho456@hotmail.com; Letícia Carvalho", "diego_monteiro789@gmail.com; Diego Monteiro", "lorena.azevedo@hotmail.com; Lorena Azevedo", "caio.martins123@gmail.com; Caio Martins", "isadora.rocha456@hotmail.com; Isadora Rocha", "samuel_melo789@gmail.com; Samuel Melo", "ana.jesus@hotmail.com; Ana Jesus", "henrique_pereira123@gmail.com; Henrique Pereira", "sophia.rodrigues456@hotmail.com; Sophia Rodrigues", "marcelo.oliveira789@gmail.com; Marcelo Oliveira", "marina_santos@hotmail.com; Marina Santos", "luiz.gomes123@gmail.com; Luiz Gomes", "larissa_faria456@hotmail.com; Larissa Faria", "rafael.costa789@gmail.com; Rafael Costa", "camila_ferreira@hotmail.com; Camila Ferreira", "bruno.machado123@gmail.com; Bruno Machado", "isabel.martins456@hotmail.com; Isabel Martins", "felipe.cardoso789@gmail.com; Felipe Cardoso", "leticia.nascimento@hotmail.com; Leticia Nascimento", "lucas.barros123@gmail.com; Lucas Barros", "amanda_ramos456@hotmail.com; Amanda Ramos", "thiago_correia789@gmail.com; Thiago Correia", "helena.melo@hotmail.com; Helena Melo", "daniel.silveira123@gmail.com; Daniel Silveira", "ana.monteiro456@hotmail.com; Ana Monteiro", "pedro.jesus789@gmail.com; Pedro Jesus", "isabella_pereira@hotmail.com; Isabella Pereira", "caio.oliveira123@gmail.com; Caio Oliveira", "gabriela_santos456@hotmail.com; Gabriela Santos", "rafaela.rodrigues789@gmail.com; Rafael Rodrigues", "larissa.almeida@hotmail.com; Larissa Almeida", "bruno.ferreira123@gmail.com; Bruno Ferreira", "leticia.martins456@hotmail.com; Leticia Martins", "lucas.correia789@gmail.com; Lucas Correia", "isabel.barros@hotmail.com; Isabel Barros", "davi.machado123@gmail.com; Davi Machado", "marina.nascimento456@hotmail.com; Marina Nascimento", "gustavo.ramos789@gmail.com; Gustavo Ramos", "camila_silva@hotmail.com; Camila Silva", "henrique.gomes123@gmail.com; Henrique Gomes", "mariana.faria456@hotmail.com; Mariana Faria", "samuel.costa789@gmail.com; Samuel Costa", "helena_monteiro@hotmail.com; Helena Monteiro", "emanuel.azevedo123@gmail.com; Emanuel Azevedo", "alice.oliveira456@gmail.com; Alice Oliveira", "enzo_santos789@hotmail.com; Enzo Santos", "bruna.martins@hotmail.com; Bruna Martins", "pedro.correia123@gmail.com; Pedro Correia", "laura_barros456@hotmail.com; Laura Barros", "gabriel.rodrigues789@gmail.com; Gabriel Rodrigues", "isabela.machado@hotmail.com; Isabela Machado", "lucas.nascimento123@gmail.com; Lucas Nascimento", "carolina.ramos456@gmail.com; Carolina Ramos", "thiago.silva789@gmail.com; Thiago Silva", "leticia.gomes123@gmail.com; Leticia Gomes", "marcelo.faria456@gmail.com; Marcelo Faria", "mariana.costa789@gmail.com; Mariana Costa", "bruno.monteiro@hotmail.com; Bruno Monteiro", "amanda.jesus123@gmail.com; Amanda Jesus", "rafaela.ferreira456@gmail.com; Rafaela Ferreira", "caio.azevedo789@gmail.com; Caio Azevedo", "larissa.oliveira@hotmail.com; Larissa Oliveira", "felipe.santos123@gmail.com; Felipe Santos", "davi.rodrigues456@gmail.com; Davi Rodrigues", "isadora.machado789@gmail.com; Isadora Machado", "lucas.barros123@gmail.com; Lucas Barros", "isabel.martins456@gmail.com; Isabel Martins", "samuel.correia789@gmail.com; Samuel Correia", "bruna.nascimento@hotmail.com; Bruna Nascimento", "enzo.ramos123@gmail.com; Enzo Ramos", "maria.silveira456@gmail.com; Maria Silveira", "joao.monteiro789@gmail.com; Joao Monteiro", "marina.santos123@gmail.com; Marina Santos", "pedro.jesus456@gmail.com; Pedro Jesus", "isabella.pereira789@gmail.com; Isabella Pereira", "lucas.oliveira123@gmail.com; Lucas Oliveira", "carolina.ferreira456@gmail.com; Carolina Ferreira", "davi.costa789@gmail.com; Davi Costa"});

    public static void main(String[] args) {

        inflateScream();

    }

    static void inflateScream() {
        final JFrame miJFrame = new JFrame("Gerador de Avaliações do Trustoo");
        miJFrame.setSize(1200, 400);

        final JPanel panel = new JPanel();
        panel.setSize(200, 200);

        final JLabel labelUrl = new JLabel();
        labelUrl.setText("URL: ");
        final JTextField url = new JTextField(20);
        panel.add(labelUrl);
        panel.add(url);

        final JLabel labelApiKey = new JLabel();
        labelApiKey.setText("API Key do ChatGPT: ");
        final JTextField apiKey = new JTextField(20);
        panel.add(labelApiKey);
        panel.add(apiKey);

        final JLabel labelDescricaoDoProduto = new JLabel();
        labelDescricaoDoProduto.setText("Descrição do produto: ");
        final JTextArea productDescription = new JTextArea(5, 20);
        panel.add(labelDescricaoDoProduto);
        panel.add(productDescription);

        final JButton button = new JButton("Gerar");
        button.addActionListener(e -> generateReviews(url.getText(), apiKey.getText(), productDescription.getText()));
        panel.add(button);

        miJFrame.add(panel);

        miJFrame.setVisible(true);
    }


    static void generateReviews(final String url, final String apiKey, final String descriptionOfProduct) {

        final List<Review> reviews = createReviews(apiKey, descriptionOfProduct);

        reviews.forEach(review -> executeReview(url, review));

        EXECUTOR_SERVICE.shutdown();

    }

    static List<Review> createReviews(final String apiKey, final String descriptionOfProduct) {

        final List<Review> reviews = new ArrayList<>();

        final List<String> messages = GPT3ReviewGenerator.generate(apiKey, descriptionOfProduct);

        for (int i = 0; i < COUNT_OF_REVIEWS; i++) {
            final String rawEmailAndName = RAW_EMAILS_AND_NAMES.get(i);
            final String email = rawEmailAndName.split(";")[0].trim();
            final String name = rawEmailAndName.split(";")[1].trim();
            final String message = messages.get(i);
            final int star;
            if (generateRandomNumberBetween0And100() < 35)
                star = 3;
            else
                star = 4;

            final Review review = new Review(name, email, message, star);
            reviews.add(review);
        }

        return reviews;
    }

    private static int generateRandomNumberBetween0And100() {
        final Random r = new Random();
        final int low = 0;
        final int high = 100;
        return r.nextInt(high-low) + low;
    }

    private static void executeReview(final String url, final Review review) {

        EXECUTOR_SERVICE.execute(() -> {

            final WebDriver driver = openBrowser();

            gotToUrl(url, driver);

            openReviewForm(driver);

            fillTheForm(driver, review);

            submitForm(driver);

            closeBrowser(driver);
        });

    }

    private static WebDriver openBrowser() {
        final WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    private static void openReviewForm(final WebDriver driver) {
        try {
            driver.findElement(By.className("head-button")).click();
        } catch (final Exception e) {
            driver.findElement(By.className("noreviews-button")).click();
        }
    }

    private static void gotToUrl(final String url, final WebDriver driver) {
        driver.get(url);
    }

    private static void fillTheForm(final WebDriver driver, final Review review) {
        driver.findElements(By.className("small-input")).get(0).sendKeys(review.getName());
        driver.findElements(By.className("small-input")).get(1).sendKeys(review.getEmail());
        driver.findElements(By.className("big-input")).get(0).sendKeys(review.getMessage());
        if (review.getStar() != 4)
            driver.findElements(By.className("trustoo-icon-star")).get(driver.findElements(By.className("trustoo-icon-star")).size() - 2).click();
    }

    private static void submitForm(final WebDriver driver) {
        final WebElement clickable = driver.findElements(By.className("form-submit")).get(0);
        new Actions(driver)
                .moveToElement(clickable)
                .pause(Duration.ofSeconds(1))
                .click()
                .build()
                .perform();
    }

    private static void closeBrowser(final WebDriver driver) {
        try {
            Thread.sleep(1000);
            driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
