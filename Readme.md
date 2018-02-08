## Sample project for basic, pure Java, serialization of XML files

### Usage

run maven to generate the java types related to your xsd files 
(the xjc plugins looks for xsd files in `src/main/xsd`) 

    mvn jaxb2:xjc
    
    
Files are generated in `target/generated-sources`

You can configure the target package in the `pom.xml` file.

Then run the `main` from `XmlSerializationDemo`

## See also

<https://stackoverflow.com/questions/25054291/how-to-create-a-jaxb-project-in-intellij-idea-13>