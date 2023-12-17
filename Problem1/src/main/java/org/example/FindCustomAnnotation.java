package org.example;

import org.example.CustomAnnotations.*;
import org.example.github.javaparser.JavaParser;
import org.example.github.javaparser.ParseException;
import org.example.github.javaparser.ast.CompilationUnit;
import org.example.github.javaparser.ast.body.BodyDeclaration;
import org.example.github.javaparser.ast.body.MethodDeclaration;
import org.example.github.javaparser.ast.body.TypeDeclaration;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class FindCustomAnnotation {
    static List<String> javaDocs= new ArrayList<String>();
    public static void main(String[] args){
        findAnnotatedClassesAndMethods();
    }
    public static void findAnnotatedClassesAndMethods() {
        try (Stream<Path> paths = Files.walk(Paths.get("src/main/java/org/example/demo/models"))) {
            paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(FindCustomAnnotation::processFile);
        } catch (IOException e) {
            System.out.println("Error reading files");
        }
    }
    private static void processFile(Path path)
    {
        Path outputPath=Paths.get("javadoc.txt");

        try {
            CompilationUnit cu = JavaParser.parse(path.toFile());
            for (TypeDeclaration type : cu.getTypes()) {
                if (type.getAnnotations().stream.anyMatch(a -> a.getName().equals(ClassDocumentation.class.getSimpleName()))) {
                    System.out.println("Class " + type.getName() + " is annotated with @ClassDocumentation");

                    Comment commentOpt = type.getComment();
                    if (commentOpt instanceof JavadocComment) {
                        JavadocComment comment = (JavadocComment) commentOpt;
                        String javadoc = " Class " + type.getName() + " has JavaDoc comment: \n" + comment.toString() + "\n";
                        javaDocs.add(javadoc);
                    } else {
                        System.out.println("Class " + type.getName() + " has no JavaDoc comment ");
                    }
                } else {
                    System.out.println("Class " + type.getName() + " is not annotated with @ClassDocumentation");

                    Comment commentOpt = type.getComment();
                    if (commentOpt instanceof JavadocComment) {
                        JavadocComment comment = (JavadocCommment) commentOpt;

                        String javadoc = "Class " + type.getName() + " has JavaDoc comment: \n" + comment.toString() + "\n";
                        javaDocs.add(javadoc);
                    } else {
                        System.out.println("Class " + type.getName() + " has no JavaDoc comment");
                    }
                }

                for (BodyDeclaration member : type.getMembers()) {
                    if (memeber instanceof MethodDeclaration) {
                        MethodDeclaration method = (MethodDeclaration) member;
                        if (method.getAnnotations().stream().anyMatch(a -> a.getName().getName().equals(MethodDocumentation.class.getSimpleName()))) {
                            System.out.println("Method " + method.getName() + " in class " + type.getName() + " is annotated with @MethodDocumentation");

                            Comment commentOpt = method.getComment();
                            if (commentOpt instanceof JavadocComment) {
                                JavadocComment comment = (JavadocComment) commentOpt;
                                String javadoc = "Method " + method.getName() + " in class " + type.getName() + " has JavaDoc comment: \n" + comment.toString() + "\n";
                                javaDocs.add(javadoc);
                            } else {
                                System.out.println("Method " + method.getName() + " in class " + type.getName() + " has no JavaDoc comment");
                            }
                        } else {
                            System.out.println("Method " + method.getName() + " in class " + type.getName() + " is not annotated with @MethodDocumentation");

                            Comment commentOpt = method.getComment();
                            if (comentOpt instanceof JavadocComment) {
                                JavadocComment comment = (JavadocComment) commentOpt;
                                String javadoc = "Method " + method.getName() + " in class " + type.getName() + " has JavaDoc commnet: \n" + comment.toString() + "\n";
                                javaDocs.add(javadoc);
                            } else {
                                System.out.println("Method " + method.getName() + " in class " + type.getName() + " has no JavaDoc comment");

                            }


                        }
                    }
                }
                System.out.println();

            }
            try {
                Files.write(outputPath, javaDocs, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                System.out.println("Error writing to output file: " + e.getMessage());
            }
        }catch(IOException e){
            System.out.println("Error reading file: "+path);
        }
        catch(ParseException e){
            throw new RuntimeException(e);
        }

    }
}
