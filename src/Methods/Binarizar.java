package Methods;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Binarizar {

    static final String CAMINHO_PADRAO = "C:\\Users\\Administrator\\IdeaProjects\\PDIBinarization\\src\\Imagem\\";

    public static BufferedImage binarizarImagem(BufferedImage imagem, int threshold) throws IOException {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_BINARY);

        for (int linha = 0; linha < largura; linha++) {
            for (int coluna = 0; coluna < altura; coluna++) {
                int pixel = imagem.getRGB(linha, coluna);
                Color cor = new Color(pixel);

                int intensidadeCinza = (cor.getRed() + cor.getGreen() + cor.getBlue()) / 3;

                if (intensidadeCinza < threshold) {
                    novaImagem.setRGB(linha, coluna, Color.BLACK.getRGB());
                } else {
                    novaImagem.setRGB(linha, coluna, Color.WHITE.getRGB());
                }
            }
        }

        String caminho = CAMINHO_PADRAO + "sombrinhas_binarizada.png";

        ImageIO.write(novaImagem, "png", new File(caminho));
        JFrame janela = new JFrame();
        ImageIcon icon = new ImageIcon(novaImagem);
        JLabel label = new JLabel(icon);
        janela.add(label);
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

        return novaImagem;
    }
}