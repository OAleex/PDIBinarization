package Main;

import Methods.Binarizar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedImage bandas = ImageIO.read(
                new File("C:\\Users\\Administrator\\IdeaProjects\\PDIBinarization\\src\\Imagem\\sombrinhas.jpg")
        );

        int limiar = 128;
        BufferedImage imagemBinarizada = Binarizar.binarizarImagem(bandas, limiar);

        String caminho = "C:\\Users\\Administrator\\IdeaProjects\\PDIBinarization\\src\\Imagem\\sombrinhas_binarizada.png";
        ImageIO.write(imagemBinarizada, "png", new File(caminho));
    }
}
