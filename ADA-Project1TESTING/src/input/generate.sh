javac GenerateDataset.java 

java  GenerateDataset 1000 > random1K.txt
java  GenerateDataset 2000 > random2K.txt
java  GenerateDataset 4000 > random4K.txt
java  GenerateDataset 8000 > random8K.txt

java -Dsorted=true GenerateDataset 1000 > sorted1K.txt
java -Dsorted=true GenerateDataset 2000 > sorted2K.txt
java -Dsorted=true GenerateDataset 4000 > sorted4K.txt
java -Dsorted=true GenerateDataset 8000 > sorted8K.txt

java -Dreversed=true GenerateDataset 1000 > reversed1K.txt
java -Dreversed=true GenerateDataset 2000 > reversed2K.txt
java -Dreversed=true GenerateDataset 4000 > reversed4K.txt
java -Dreversed=true GenerateDataset 8000 > reversed8K.txt


java GenerateDataset 1000 654321 > identical1K.txt
java GenerateDataset 2000 654321 > identical2K.txt
java GenerateDataset 4000 654321 > identical4K.txt
java GenerateDataset 8000 654321 > identical8K.txt
