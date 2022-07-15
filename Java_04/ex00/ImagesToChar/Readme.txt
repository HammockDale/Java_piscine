# Delete target directory
rm -rf target

# Make target directory
mkdir -p target

# Set the destination directory for class files
javac -d ./target src/java/edu/school21/printer/*/*.java

# Specify where to find user class files
java -cp target edu.school21.printer.app.Program /Users/hdale/Downloads/it.bmp . 0