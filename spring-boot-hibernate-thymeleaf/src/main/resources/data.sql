INSERT INTO 
	TBL_EMPLOYEES (first_name, last_name, employment_id, start_date, end_date, designation, department, status, DOB, reporting_mgr, gender, blood_group, address) 
VALUES
  	('Lokesh', 'Gupta', '1101', '15-03-2002', 'NA', 'Engineer', 'Development', 'active', '01-05-1980', 'K.Agarwal', 'M', 'AB-', 'Hall Road, Bangalore'),
  	('Abhishek', 'Kumar', '1102', '15-11-2010', 'NA', 'Accountant', 'Banking', 'active', '01-05-1990', 'K.Mehta', 'M', 'B+', 'Mall Road, Bikaner');

INSERT INTO 
	TBL_DEPENDANTS (employee_id, first_name, last_name, gender, DOB, relationship)
VALUES
	(1, 'Hariharan', 'Gupta', 'M', '31-01-1954', 'Father'),
	(2, 'Sita', 'Devi', 'F', '05-05-1970', 'Mother');

INSERT INTO
	TBL_EDUCATIONAL_QUALIFICATIONS (employee_id, type, start_date, end_date, institution, address, percentage)
VALUES
	(1, 'Full-time', '25-07-1997', '25-07-2001', 'ABC, State', 'Andhra Pradesh', 74.8);