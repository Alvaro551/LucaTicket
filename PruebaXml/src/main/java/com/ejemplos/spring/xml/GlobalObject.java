package com.ejemplos.spring.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class GlobalObject {

    @XmlElement(name = "RDR_Actual_Date")
    private String rdrActualDate;

    @XmlElement(name = "RDR_Code_Global")
    private String rdrCodeGlobal;

    @XmlElement(name = "RDR_Code_Global_Source")
    private String rdrCodeGlobalSource;

    @XmlElement(name = "Counterparty_Type")
    private String counterpartyType;

    @XmlElement(name = "Bank_Indicator")
    private String bankIndicator;

    @XmlElement(name = "Investment_Firm")
    private String investmentFirm;

    @XmlElement(name = "Investment_Firm_UK")
    private String investmentFirmUK;

    @XmlElement(name = "Personality")
    private String personality;

    @XmlElement(name = "Personality_SubType")
    private String personalitySubType;

    @XmlElement(name = "Enterprise_Owner")
    private String enterpriseOwner;

    @XmlElement(name = "Branch_Owner")
    private String branchOwner;

    @XmlElement(name = "Country_of_Origin")
    private String countryOfOrigin;

    @XmlElement(name = "Legal_Name")
    private String legalName;

    @XmlElement(name = "Legal_Regime")
    private String legalRegime;

    @XmlElement(name = "Legal_Name_Source")
    private String legalNameSource;

    @XmlElement(name = "Establishment_date")
    private String establishmentDate;

    @XmlElement(name = "LEI")
    private String lei;

    @XmlElement(name = "LEI_DATA_STAT_TYP")
    private String leiDataStatTyp;

    @XmlElement(name = "LEI_INFORMATION")
    private String leiInformation;

    @XmlElement(name = "ENTITY_IDENTIFIERS")
    private String entityIdentifiers;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "Start_Date_Time")
    private String startDateTime;

    @XmlElement(name = "Last_Changed_Date_Time")
    private String lastChangedDateTime;

    @XmlElement(name = "Last_Changed_User")
    private String lastChangedUser;

    @XmlElementWrapper(name = "REGULATORY_INFORMATION")
    @XmlElement(name = "REGULATORY_INFORMATION")
    private List<RegulatoryInformation> regulatoryInformationList;

    public String getRdrActualDate() {
        return rdrActualDate;
    }

    public void setRdrActualDate(String rdrActualDate) {
        this.rdrActualDate = rdrActualDate;
    }

    public String getRdrCodeGlobal() {
        return rdrCodeGlobal;
    }

    public void setRdrCodeGlobal(String rdrCodeGlobal) {
        this.rdrCodeGlobal = rdrCodeGlobal;
    }

    public String getRdrCodeGlobalSource() {
        return rdrCodeGlobalSource;
    }

    public void setRdrCodeGlobalSource(String rdrCodeGlobalSource) {
        this.rdrCodeGlobalSource = rdrCodeGlobalSource;
    }

    public String getCounterpartyType() {
        return counterpartyType;
    }

    public void setCounterpartyType(String counterpartyType) {
        this.counterpartyType = counterpartyType;
    }

    public String getBankIndicator() {
        return bankIndicator;
    }

    public void setBankIndicator(String bankIndicator) {
        this.bankIndicator = bankIndicator;
    }

    public String getInvestmentFirm() {
        return investmentFirm;
    }

    public void setInvestmentFirm(String investmentFirm) {
        this.investmentFirm = investmentFirm;
    }

    public String getInvestmentFirmUK() {
        return investmentFirmUK;
    }

    public void setInvestmentFirmUK(String investmentFirmUK) {
        this.investmentFirmUK = investmentFirmUK;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getPersonalitySubType() {
        return personalitySubType;
    }

    public void setPersonalitySubType(String personalitySubType) {
        this.personalitySubType = personalitySubType;
    }

    public String getEnterpriseOwner() {
        return enterpriseOwner;
    }

    public void setEnterpriseOwner(String enterpriseOwner) {
        this.enterpriseOwner = enterpriseOwner;
    }

    public String getBranchOwner() {
        return branchOwner;
    }

    public void setBranchOwner(String branchOwner) {
        this.branchOwner = branchOwner;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getLegalRegime() {
        return legalRegime;
    }

    public void setLegalRegime(String legalRegime) {
        this.legalRegime = legalRegime;
    }

    public String getLegalNameSource() {
        return legalNameSource;
    }

    public void setLegalNameSource(String legalNameSource) {
        this.legalNameSource = legalNameSource;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    public String getLeiDataStatTyp() {
        return leiDataStatTyp;
    }

    public void setLeiDataStatTyp(String leiDataStatTyp) {
        this.leiDataStatTyp = leiDataStatTyp;
    }

    public String getLeiInformation() {
        return leiInformation;
    }

    public void setLeiInformation(String leiInformation) {
        this.leiInformation = leiInformation;
    }

    public String getEntityIdentifiers() {
        return entityIdentifiers;
    }

    public void setEntityIdentifiers(String entityIdentifiers) {
        this.entityIdentifiers = entityIdentifiers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getLastChangedDateTime() {
        return lastChangedDateTime;
    }

    public void setLastChangedDateTime(String lastChangedDateTime) {
        this.lastChangedDateTime = lastChangedDateTime;
    }

    public String getLastChangedUser() {
        return lastChangedUser;
    }

    public void setLastChangedUser(String lastChangedUser) {
        this.lastChangedUser = lastChangedUser;
    }

    public List<RegulatoryInformation> getRegulatoryInformationList() {
        return regulatoryInformationList;
    }

    public void setRegulatoryInformationList(List<RegulatoryInformation> regulatoryInformationList) {
        this.regulatoryInformationList = regulatoryInformationList;
    }
}
