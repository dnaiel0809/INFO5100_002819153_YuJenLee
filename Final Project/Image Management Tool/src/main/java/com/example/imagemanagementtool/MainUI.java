package com.example.imagemanagementtool;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class MainUI extends VBox {
    private FileChooser fileChooser = new FileChooser();

    public MainUI() {
        Label titleLabel = new Label("Image Converter App");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        HBox imageUploadBox = createImageUploadBox();


        getChildren().addAll(titleLabel, imageUploadBox);
        setSpacing(20);
        setPadding(new Insets(20));
        setAlignment(Pos.TOP_CENTER);
    }

    private HBox createImageUploadBox() {
        HBox box = new HBox(10);

        Button uploadButton = new Button("Upload Image");
        uploadButton.setOnAction(event -> uploadImage());


        box.getChildren().addAll(uploadButton);

        return box;
    }

    private HBox createImageConversionBox(File file) {
        HBox box = new HBox(10);

        Label conversionLabel = new Label("Convert to:");
        ComboBox<String> formatComboBox = new ComboBox<>();
        formatComboBox.getItems().addAll("PNG", "JPEG", "GIF");

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(event -> {

            String selectedFormat = formatComboBox.getValue();
            if (selectedFormat != null) {

                convertImage(selectedFormat, file);
            }
        });


        box.getChildren().addAll(conversionLabel, formatComboBox, convertButton);

        return box;
    }

    private void uploadImage() {
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            displayThumbnail(file);
            displayImageProperties(file);

        }
    }

    private void displayThumbnail(File file) {
        ImageView thumbnailImageView = new ImageView();
        thumbnailImageView.setFitWidth(100);
        thumbnailImageView.setFitHeight(100);

        try {
            Image image = new Image(file.toURI().toString());
            thumbnailImageView.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }


        getChildren().add(thumbnailImageView);
    }

    private void displayImageProperties(File file) {

        TextArea propertiesTextArea = new TextArea();
        propertiesTextArea.setEditable(false);
        propertiesTextArea.setPrefRowCount(5);

        try {

            BufferedImage bufferedImage = ImageIO.read(file);
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            HBox imageConversionBox = createImageConversionBox(file);
            getChildren().addAll(imageConversionBox);
            ImageIO.write(bufferedImage, "png", file);

            String properties = String.format(
                    "Width: %d\nHeight: %d\n", width, height);

            propertiesTextArea.setText(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }


        getChildren().add(propertiesTextArea);
    }

    private void convertImage(String format, File originalFile) {

        File outputFile = new File("converted_image." + format.toLowerCase());


        try {
            BufferedImage bufferedImage = ImageIO.read(originalFile);
            ByteArrayInputStream bis = new ByteArrayInputStream(writeBytes(bufferedImage,format));
            bufferedImage = ImageIO.read(bis);

            switch (format.toUpperCase()) {
                case "PNG":
                    ImageIO.write(bufferedImage, "png", outputFile);
                    break;
                case "JPEG":
                    ImageIO.write(bufferedImage, "jpeg", outputFile);
                    System.out.println("Image converted successfully. Saved to: " + outputFile.getAbsolutePath());
                    break;
                case "GIF":
                    ImageIO.write(bufferedImage, "gif", outputFile);
                    break;
                default:

                    System.out.println("Unsupported format: " + format);
                    return;
            }


            System.out.println("Image converted successfully. Saved to: " + outputFile.getAbsolutePath());
            Text text = new Text("Image converted successfully. Saved to: " + outputFile.getAbsolutePath());
            getChildren().addAll(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static byte[] writeBytes(BufferedImage source, String formatName){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Graphics2D g = null;
        try{
            for(BufferedImage s = source; ! ImageIO.write(s, formatName, output);){
                if (g!=null)
                    throw new IllegalAccessException(String.format("not found writer for '%s'",formatName));
                s = new BufferedImage(source.getWidth(),source.getHeight(),BufferedImage.TYPE_INT_BGR);
                g = s.createGraphics();
                g.drawImage(source,0,0,null);
            }
        }catch (IOException | IllegalAccessException e){
            throw new RuntimeException(e);
        }finally {
            if (null !=g)
                g.dispose();
        }
        return output.toByteArray();
    }
}
