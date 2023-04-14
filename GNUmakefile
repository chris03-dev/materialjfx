# Makefile variables
JARNAME := mjfx-demo.jar
MANIFEST := manifest.txt

SOURCE_DIR := materialjfx/
SOURCES := $(shell find materialjfx/ -name "*.java"  -type f)
CLASSES := $(shell find materialjfx/ -name "*.class" -type f)
MODULES := javafx.swing,javafx.controls
MODULE_DIR := /usr/lib/jvm/default/lib/
MODULE_DIRFX := /usr/lib/jvm/default/lib/javafx.base.jar:/usr/lib/jvm/default/lib/javafx.graphics.jar:/usr/lib/jvm/default/lib/javafx.swing.jar:/usr/lib/jvm/default/lib/javafx.controls.jar:usr/lib/jvm/default/lib/jrt-fs.jar

.PHONY: all clean

# java --module-path usr/lib/jvm/default/lib/javafx.base.jar:/usr/lib/jvm/default/lib/javafx.controls.jar:/usr/lib/jvm/default/lib/javafx.graphics.jar --add-modules javafx.swing,javafx.graphics,javafx.controls materialjfx/TestBed
# java --add-modules javafx.base,javafx.swing,javafx.graphics,javafx.controls  --module-path /usr/lib/jvm/default/lib/javafx.base.jar:/usr/lib/jvm/default/lib/javafx.graphics.jar:/usr/lib/jvm/default/lib/javafx.swing.jar:/usr/lib/jvm/default/lib/javafx.controls.jar materialjfx/TestBed

# java --module-path /usr/lib/jvm/default/lib/javafx.base.jar:usr/lib/jvm/default/lib/javafx.graphics.jar:/usr/lib/jvm/default/lib/javafx.swing.jar:/usr/lib/jvm/default/lib/javafx.controls.jar:usr/lib/jvm/default/lib/jrt-fs.jar --add-modules javafx.swing,javafx.graphics,javafx.controls materialjfx/TestBed


#@java --module-path $(MODULE_DIRFX) --add-modules $(MODULES) $(CLASSNAME) -jar $(JARNAME)
	
all: $(CLASSFILE)
	@jar cfm $(JARNAME) $(MANIFEST) $(SOURCE_DIR)
	@java --module-path $(MODULE_DIRFX) --add-modules $(MODULES) -jar $(JARNAME)

clean: $(CLASSES)
	@rm -rf $(CLASSES)

$(CLASSFILE):
	@javac --add-modules $(MODULES) --module-path $(MODULE_DIR) $(SOURCES)

