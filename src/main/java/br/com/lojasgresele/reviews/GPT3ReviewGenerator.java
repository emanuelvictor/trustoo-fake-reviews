package br.com.lojasgresele.reviews;

import com.azure.ai.openai.OpenAIAsyncClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.Choice;
import com.azure.ai.openai.models.Completions;
import com.azure.ai.openai.models.CompletionsOptions;
import com.azure.ai.openai.models.NonAzureOpenAIKeyCredential;

import java.util.ArrayList;
import java.util.List;

import static com.azure.ai.openai.implementation.CompletionsUtils.DEFAULT_MAX_COMPLETION_TOKENS;


public class GPT3ReviewGenerator {

    public static int COUNT_OF_REVIEWS = 25;

    private static final List<String> messages = new ArrayList<>();

    public static List<String> generate(final String apiKey, final String descriptionOfProduct) {
        final String apiUrl = "v1/chat/completions?";  // URL correta para GPT-3


        final OpenAIAsyncClient client = new OpenAIClientBuilder()
                .credential(new NonAzureOpenAIKeyCredential(apiKey))
                .endpoint(apiUrl)
                .buildAsyncClient();

        final List<String> prompt = new ArrayList<>();
        prompt.add("Gere avaliações curtas, com no máximo 20 palavras, fictícias com linguagem coloquial, que pareçam naturais, com um pouco de erros ortográficos, jargões, gírias, abreviaturas e um toque de humor, sobre um item da minha loja com essas características:" +
                descriptionOfProduct
        );

        final CompletionsOptions completionsOptions = new CompletionsOptions(prompt);
        completionsOptions.setN(COUNT_OF_REVIEWS);
        completionsOptions.setMaxTokens(DEFAULT_MAX_COMPLETION_TOKENS);
        final Completions completions = client.getCompletions("text-davinci-003", completionsOptions).block();

        assert completions != null;
        for (Choice choice : completions.getChoices())
            messages.add(choice.getText().trim().replace("\"", ""));

        return messages;
    }

}
