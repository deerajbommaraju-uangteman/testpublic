//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.27 at 05:44:14 PM IST 
//


package cimb3rdparty.billpaymentws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentRq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentRq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}TransactionID" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}ChannelID" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}TerminalID" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}TransactionDate" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}CompanyCode" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}CustomerKey1" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}CustomerKey2" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}CustomerKey3" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}Language" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}Currency" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}Amount" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}Fee" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}PaidAmount" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}ReferenceNumberTransaction" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}FlagPaymentList" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}CustomerName" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}AdditionalData1" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}AdditionalData2" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}AdditionalData3" minOccurs="0"/>
 *         &lt;element ref="{http://CIMB3rdParty/BillPaymentWS}AdditionalData4" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentRq", propOrder = {
    "transactionID",
    "channelID",
    "terminalID",
    "transactionDate",
    "companyCode",
    "customerKey1",
    "customerKey2",
    "customerKey3",
    "language",
    "currency",
    "amount",
    "fee",
    "paidAmount",
    "referenceNumberTransaction",
    "flagPaymentList",
    "customerName",
    "additionalData1",
    "additionalData2",
    "additionalData3",
    "additionalData4"
})
public class PaymentRq {

    @XmlElement(name = "TransactionID")
    protected String transactionID;
    @XmlElement(name = "ChannelID")
    protected String channelID;
    @XmlElement(name = "TerminalID")
    protected String terminalID;
    @XmlElement(name = "TransactionDate")
    protected String transactionDate;
    @XmlElement(name = "CompanyCode")
    protected String companyCode;
    @XmlElement(name = "CustomerKey1")
    protected String customerKey1;
    @XmlElement(name = "CustomerKey2")
    protected String customerKey2;
    @XmlElement(name = "CustomerKey3")
    protected String customerKey3;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "Amount")
    protected Integer amount;
    @XmlElement(name = "Fee")
    protected Integer fee;
    @XmlElement(name = "PaidAmount")
    protected Integer paidAmount;
    @XmlElement(name = "ReferenceNumberTransaction")
    protected String referenceNumberTransaction;
    @XmlElement(name = "FlagPaymentList")
    protected String flagPaymentList;
    @XmlElement(name = "CustomerName")
    protected String customerName;
    @XmlElement(name = "AdditionalData1")
    protected String additionalData1;
    @XmlElement(name = "AdditionalData2")
    protected String additionalData2;
    @XmlElement(name = "AdditionalData3")
    protected String additionalData3;
    @XmlElement(name = "AdditionalData4")
    protected String additionalData4;

    /**
     * Gets the value of the transactionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionID(String value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the channelID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelID() {
        return channelID;
    }

    /**
     * Sets the value of the channelID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelID(String value) {
        this.channelID = value;
    }

    /**
     * Gets the value of the terminalID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalID() {
        return terminalID;
    }

    /**
     * Sets the value of the terminalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalID(String value) {
        this.terminalID = value;
    }

    /**
     * Gets the value of the transactionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the value of the transactionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionDate(String value) {
        this.transactionDate = value;
    }

    /**
     * Gets the value of the companyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * Sets the value of the companyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyCode(String value) {
        this.companyCode = value;
    }

    /**
     * Gets the value of the customerKey1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerKey1() {
        return customerKey1;
    }

    /**
     * Sets the value of the customerKey1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerKey1(String value) {
        this.customerKey1 = value;
    }

    /**
     * Gets the value of the customerKey2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerKey2() {
        return customerKey2;
    }

    /**
     * Sets the value of the customerKey2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerKey2(String value) {
        this.customerKey2 = value;
    }

    /**
     * Gets the value of the customerKey3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerKey3() {
        return customerKey3;
    }

    /**
     * Sets the value of the customerKey3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerKey3(String value) {
        this.customerKey3 = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAmount(Integer value) {
        this.amount = value;
    }

    /**
     * Gets the value of the fee property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFee() {
        return fee;
    }

    /**
     * Sets the value of the fee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFee(Integer value) {
        this.fee = value;
    }

    /**
     * Gets the value of the paidAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPaidAmount() {
        return paidAmount;
    }

    /**
     * Sets the value of the paidAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPaidAmount(Integer value) {
        this.paidAmount = value;
    }

    /**
     * Gets the value of the referenceNumberTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceNumberTransaction() {
        return referenceNumberTransaction;
    }

    /**
     * Sets the value of the referenceNumberTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceNumberTransaction(String value) {
        this.referenceNumberTransaction = value;
    }

    /**
     * Gets the value of the flagPaymentList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagPaymentList() {
        return flagPaymentList;
    }

    /**
     * Sets the value of the flagPaymentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagPaymentList(String value) {
        this.flagPaymentList = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the additionalData1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalData1() {
        return additionalData1;
    }

    /**
     * Sets the value of the additionalData1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalData1(String value) {
        this.additionalData1 = value;
    }

    /**
     * Gets the value of the additionalData2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalData2() {
        return additionalData2;
    }

    /**
     * Sets the value of the additionalData2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalData2(String value) {
        this.additionalData2 = value;
    }

    /**
     * Gets the value of the additionalData3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalData3() {
        return additionalData3;
    }

    /**
     * Sets the value of the additionalData3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalData3(String value) {
        this.additionalData3 = value;
    }

    /**
     * Gets the value of the additionalData4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalData4() {
        return additionalData4;
    }

    /**
     * Sets the value of the additionalData4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalData4(String value) {
        this.additionalData4 = value;
    }

}
