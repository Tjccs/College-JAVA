delete from SALEPRODUCT
delete from SALE
delete from CUSTOMER
delete from PRODUCT
delete from DISCOUNT
delete from UNIT
delete from DEPARTMENT
delete from EMPLOYEE
INSERT INTO DISCOUNT (ID, DTYPE, DESCRIPTION, PERCENTAGE, THRESHOLD) VALUES (1, 'NoDiscount', 'Sem desconto', 0, 0)
INSERT INTO DISCOUNT (ID, DTYPE, DESCRIPTION, PERCENTAGE, THRESHOLD) VALUES (2, 'ThresholdPercentageDiscount', 'Percentagem do Total (acima de limiar)', 0.1, 50)
INSERT INTO DISCOUNT (ID, DTYPE, DESCRIPTION, PERCENTAGE, THRESHOLD) VALUES (3, 'EligibleProductsDiscount', 'Percentagem do Total Elegivel', 0.1, 0)
INSERT INTO UNIT (ID, DESCRIPTION, ABBREVIATION) VALUES (1, 'Quilogramas', 'Kg')
INSERT INTO UNIT (ID, DESCRIPTION, ABBREVIATION) VALUES (2, 'Unidades', 'un')
INSERT INTO PRODUCT (ID, PRODCOD, DESCRIPTION, FACEVALUE, QTY, DISCOUNTELIGIBILITY, UNIT_ID) VALUES (1, 123, 'Prod 1', 100, 500, 0, 1)
INSERT INTO PRODUCT (ID, PRODCOD, DESCRIPTION, FACEVALUE, QTY, DISCOUNTELIGIBILITY, UNIT_ID) VALUES (2, 124, 'Prod 2', 35, 1000, 1, 2)