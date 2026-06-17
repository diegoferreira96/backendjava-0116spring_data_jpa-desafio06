package br.com.alura.screensound.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import io.github.cdimascio.dotenv.Dotenv;

public class ConsultaGemini {
    public static String obterInfomacao(String texto){
        Dotenv dotenv = Dotenv.load(); // 1. Inicializa o Dotenv (carrega o arquivo .env da raiz por padrão)
        String apiKey = dotenv.get("GEMINI_API_KEY"); // 2. Recupera a chave salva no arquivo

        ChatLanguageModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .build();

        String resposta = model.chat("Me fale sobre o artista " + texto);
        return "Resposta da IA: " + resposta;
    }

}
