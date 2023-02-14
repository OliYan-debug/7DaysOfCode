package imbd.top250.Util;

import imbd.top250.Model.Content;
import java.io.PrintWriter;
import java.util.List;

public class HtmlGenerator {
    PrintWriter writer;
    private String top =
            """
            <!DOCTYPE>
            <html>
            <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">				\t
                <title>My Auto Generated HTML</title>
            </head>
            <body>
            <div class="container d-flex flex-wrap align-items-center">
            """;
    private String divTemplate =
            """
                <div class="card m-2 p-2 text-white bg-dark mb-3" style="width: 250px; height:450px; text-align:center; font-size: 1.2rem">
                    <h5 class="card-header" style="text-align: start;">%s</h5>
                    <p class="text-muted">%s</p>
                    <div class="card-body">
                        <img class="card-img" style="max-height: 200px; max-width:150px" src="%s" alt="%s">
                        <p class="card-text mt-2">Ano: %s</p>
                    </div>
                </div>
            """;

    private String bottom =
            """
            </div>
            </body>
            </html>
            """;

    public HtmlGenerator(PrintWriter writer){
        this.writer = writer;
    }
    public void generate(List<? extends Content> models){
        writer.println(top);

        for(Content model : models){
            writer.println(String.format(divTemplate,
                    model.title(),
                    model.type(),
                    model.imageUrl(),
                    model.title(),
                    model.year()
                    ));
        }

        writer.println(bottom);
        System.out.println("Html gerado com sucesso!");
    }
}
