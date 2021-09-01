package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UniProdCustomizedColumns {

    WebDriver driver;

    public UniProdCustomizedColumns(WebDriver driver) {
        this.driver = driver;
    }

    By reviewedCross = By.cssSelector("#reviewed-column-input-selected div");
    By lengthCross = By.cssSelector("#length-column-input-selected div");
    By pathway = By.cssSelector("#comment_8_PATHWAY_9_-column-input");
    By geneOntologyExpand = By.cssSelector("#customize-columns-choices > div:nth-child(2) > div.customizeField.gene_ontology > a");
    By goInput = By.cssSelector("#go-column-input");
    By goID = By.cssSelector("#go-id-column-input");
    By taxonomicLineageExpand = By.cssSelector("#customize-columns-choices > div:nth-child(4) > div.customizeField.tax_lineage > a");
    By tlKingdom = By.cssSelector("#lineage_8_KINGDOM_9_-column-input");
    By tlSubKingdom = By.cssSelector("#lineage_8_SUBKINGDOM_9_-column-input");
    By tlPhylum = By.cssSelector("#lineage_8_PHYLUM_9_-column-input");
    By tlSubPhylum = By.cssSelector("#lineage_8_SUBPHYLUM_9_-column-input");
    By tlClass = By.cssSelector("#lineage_8_CLASS_9_-column-input");
    By tlOrder = By.cssSelector("#lineage_8_ORDER_9_-column-input");
    By tlFamily = By.cssSelector("#lineage_8_FAMILY_9_-column-input");
    By tlGenus = By.cssSelector("#lineage_8_GENUS_9_-column-input");
    By tlSpices = By.cssSelector("#lineage_8_SPECIES_9_-column-input");
    By saveButton = By.cssSelector("#top-customize-columns-save");

    public UniProdCustomizedColumns arrangeColumns(){
        driver.findElement(reviewedCross).click();
        driver.findElement(lengthCross).click();
        driver.findElement(pathway).click();

        driver.findElement(geneOntologyExpand).click();

        driver.findElement(goInput).click();
        driver.findElement(goID).click();

        driver.findElement(taxonomicLineageExpand).click();

        driver.findElement(tlKingdom).click();
        driver.findElement(tlSubKingdom).click();
        driver.findElement(tlPhylum).click();
        driver.findElement(tlSubPhylum).click();
        driver.findElement(tlClass).click();
        driver.findElement(tlOrder).click();
        driver.findElement(tlFamily).click();
        driver.findElement(tlGenus).click();
        driver.findElement(tlSpices).click();

        driver.findElement(saveButton).click();

        driver.switchTo().alert().accept();

        return this;
    }
}
