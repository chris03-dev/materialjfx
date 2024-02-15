# Makefile variables
JARFILE := mjfx-demo.jar
CLASSFILE := materialjfx/TestBed.class
MANIFEST := manifest.txt

SOURCE_DIR := materialjfx/
SOURCES := $(shell find materialjfx/ -name "*.java"  -type f -printf "%p ")
CLASSES := $(shell find materialjfx/ -name "*.class" -type f -printf "%p ")
MODULES := javafx.swing,javafx.controls
MODULE_DIR != if [ -d /usr/lib/jvm/default/lib/ ]; then echo /usr/lib/jvm/default/lib/; elif [ -d /usr/lib/jvm/default-java/lib/ ]; then echo /usr/lib/jvm/default-java/lib/; fi
MODULE_DIRFX := /usr/share/openjfx/lib/javafx.base.jar:/usr/share/openjfx/lib/javafx.graphics.jar:/usr/share/openjfx/lib/javafx.swing.jar:/usr/share/openjfx/lib/javafx.controls.jar:usr/lib/jvm/default/lib/jrt-fs.jar

# /usr/lib/jvm/default/lib/javafx.base.jar:/usr/lib/jvm/default/lib/javafx.graphics.jar:/usr/lib/jvm/default/lib/javafx.swing.jar:/usr/lib/jvm/default/lib/javafx.controls.jar:usr/lib/jvm/default/lib/jrt-fs.jar

.PHONY: run build class clean

run: $(JARFILE)
	@echo Running JAR file "$(JARFILE)"...
	java --module-path $(MODULE_DIRFX) --add-modules $(MODULES) -jar $(JARFILE)
	@echo ---

jar: $(CLASSFILE)
	@echo Generating JAR file "$(JARFILE)"...
	jar cfm $(JARFILE) $(MANIFEST) $(SOURCE_DIR)
	@echo ---

class:
	@echo Generating classfiles...
	javac --add-modules $(MODULES) --module-path $(MODULE_DIR):$(MODULE_DIRFX) $(SOURCES)
	@echo ---

clean: clean-jar clean-class clean-logs

clean-jar:
	@echo Removing JAR file "$(JARFILE)"...
	@rm -f $(JARFILE)
	@echo ---

clean-class:
	@echo Removing classfiles...
	@./clean-classfiles.sh
	@echo ---

clean-logs:
	@echo Deleting logs...
	@rm -f ./*.log
	@echo ---