package br.com.eloaca.java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GeradoraDeFigurinhas {

    public void gerador(final InputStream stream, final String texto, final String nomeArquivo) throws IOException {

        final var pahtName = "image/imagem.jpg";

        final var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        final var cor = new Color(0xE65E03);

        BufferedImage imagemOriginal = ImageIO.read(stream);

        var largura = imagemOriginal.getWidth();
        var altura = imagemOriginal.getHeight();
        var novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();

        graphics.drawImage(imagemOriginal, 0, 0, null);
        graphics.setFont(fonte);
        graphics.setColor(cor);
        graphics.drawString(texto, 100, novaAltura - 100);

        var caminhoNovoArquivo = "image/".concat(nomeArquivo);

        ImageIO.write(novaImagem, "png", new File(caminhoNovoArquivo));
    }
}
