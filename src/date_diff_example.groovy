def fmt = 'MM/dd/yyyy'
def difference_in_days = Date.parse(fmt, '11/12/2010') - Date.parse(fmt, '10/29/2009')
assert difference_in_days == 365 + 2 + 12
assert difference_in_days == 379
