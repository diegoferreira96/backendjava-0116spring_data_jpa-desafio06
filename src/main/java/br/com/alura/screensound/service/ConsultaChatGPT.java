package br.com.alura.screensound.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

    public static String obterInformacao(String texto){
        OpenAiService service = new OpenAiService(System.getenv("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"));

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("me fale sobre o artista: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
