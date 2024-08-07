package vn.bigdata.vncorenlp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vn.bigdata.vncorenlp.layer.application.domain.pipeline.Annotation;
import vn.bigdata.vncorenlp.layer.application.domain.pipeline.Sentence;
import vn.bigdata.vncorenlp.layer.application.domain.pipeline.VnCoreNLP;

import java.io.IOException;
import java.io.PrintStream;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void vnCoreNLPTest() throws IOException {
        // "wseg", "pos", "ner", and "parse" refer to as word segmentation, POS tagging, NER and dependency parsing, respectively.
        String[] annotators = {"wseg", "pos", "ner", "parse"};
        VnCoreNLP pipeline = new VnCoreNLP(annotators);

        String str = "Ông Nguyễn Khắc Chúc  đang làm việc tại Đại học Quốc gia Hà Nội. "
                + "Bà Lan, vợ ông Chúc, cũng làm việc tại đây.";
        Annotation annotation = new Annotation(str);
        pipeline.annotate(annotation);

        System.out.println(annotation.toString());
        // 1    Ông                 Nc  O       4   sub
        // 2    Nguyễn_Khắc_Chúc    Np  B-PER   1   nmod
        // 3    đang                R   O       4   adv
        // 4    làm_việc            V   O       0   root
        // ...

        //Write to file
        PrintStream outputPrinter = new PrintStream("output.txt");
        pipeline.printToFile(annotation, outputPrinter);

        // You can also get a single sentence to analyze individually
        Sentence firstSentence = annotation.getSentences().get(0);
        System.out.println(firstSentence.toString());
    }
}
