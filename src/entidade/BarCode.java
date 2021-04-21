/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class BarCode {

    @SuppressWarnings("static-access")
    public static final String embasa = "./embasa.jpg";

    public static void main(String args[]) {

        System.out.println("Barcode Linha de Código ");

    }

    public static PdfPCell createImageCell(String path) throws DocumentException, IOException {
        Image img = Image.getInstance(path);
        PdfPCell cell = new PdfPCell(img, true);
        return cell;
    }

    public static void gerarLista(ArrayList lista) {
        JFileChooser chooser = new JFileChooser(); 
        int retornaResp = chooser.showSaveDialog(null); 
        if (retornaResp == JFileChooser.APPROVE_OPTION) {
           // File arquivo = new File(chooser.getSelectedFile().getAbsolutePath()); 
        }
        Rectangle rect = new Rectangle(142, 85); //Etiqueta 30 x 50
        //Rectangle rect = new Rectangle(142, 57); //Etiqueta 20 x 50
        Document document = new Document(rect, 20, 10, 25, 25);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(chooser.getSelectedFile().getAbsolutePath() + ".pdf"));

//abrindo o documento.
            document.open();

//adicionando um novo paragrafo.
//            document.add(new Paragraph("CÓDIGOS DE BARRA"));
//
//            document.add(new Paragraph(" "));
//
//            document.add(new Paragraph(" "));
            //Comecando a configurar o cod de barras
            PdfContentByte cb = writer.getDirectContent();
            PdfPTable table = new PdfPTable(2);
            Image imagem = Image.getInstance(embasa);
            imagem.scalePercent(25);
            imagem.setAbsolutePosition(43, 60); //Etiqueta 30 x 50
            //imagem.setAbsolutePosition(43, 34); //Etiqueta 20 x 50
            Barcode128 code128 = new Barcode128();

//            ArrayList<String> lista = new ArrayList<String>();
            //O iText suporta os principais tipos de código de barra, como Barcode39,
            //  Barcode128 (128, 128_UCC, 128_RAW),  BarcodeEAN (EAN13, EAN8, UPCA, UPCE), EANSUP, etc
            code128.setCodeType(code128.CODE128);
            
            //code128.setSize(25);
            //code128.setBaseline(0); //Discomentar essas 2 linhas para gerar código do saco
            
            //code128.setTextAlignment(40);

            //criar um metodo para ler do arquivo e inserir na lista
//            lista.add("A13N108028");
            for (int i = 0; i < lista.size(); i++) {
                code128.setCode((String) lista.get(i));
                cb.addImage(imagem);
                Image image128 = code128.createImageWithBarcode(cb, null, null);
                //table.addCell(createImageCell(embasa));
                //document.add(table);
                document.add(image128);
                //Adiciona proxima pagina no pdf
                if (i != lista.size()) {
                    document.newPage();
                }

            }

        } catch (Exception de) {
            de.printStackTrace();

        }
        document.close();

    }
}
