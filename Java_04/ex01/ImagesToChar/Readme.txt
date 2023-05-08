# Delete target directory
rm -rf target

# Make target directory
mkdir -p target

# Set the destination directory for class files
javac -d ./target src/java/edu/school21/printer/*/*.java

cp -R src/resources target/.

jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

chmod u+x target/images-to-chars-printer.jar

java -jar target/images-to-chars-printer.jar . 0
