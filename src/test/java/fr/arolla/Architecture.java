package fr.arolla;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.lang.syntax.ClassesIdentityTransformer.classes;

/**
 * Created by lenovo_9 on 10/04/2018.
 */
public class Architecture {

    @Test
    public void some_architecture_rule() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("fr.arolla");

        ArchRule rule = noClasses().that().resideInAPackage("..core..")
                .should().accessClassesThat()
                .resideInAPackage("..infra..");



        rule.check(importedClasses);
    }
}

