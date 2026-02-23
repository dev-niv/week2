# 6. Source → Canonical Mapping

---

## FENERGO Mapping

| Source Column | Canonical Column |
|---------------|------------------|
customer_name | customer_name  
customer_type | customer_type  
country_code | country_code  
risk_rating | risk_rating  
snapshot_date | snapshot_date  

---

## GEARS Mapping

| Source Column | Canonical Column |
|---------------|------------------|
account_status | status  
transaction_count | transaction_count  
total_value | total_value  
snapshot_date | snapshot_date  

---

## Identity Mapping

| Source | Field |
|--------|------|
FENERGO | kyc_unified_id  
GEARS | kyc_unified_id  
