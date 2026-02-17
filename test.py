import psycopg2
def get_connection():
    try:
        return psycopg2.connect(
            database="Info",
            user="admin",
            password="root",
            host="127.0.0.1",
            port=5432,
        )
    except:
        return False
conn = get_connection()
if conn:
    print("Connection to the PostgreSQL established successfully.")

    cursor = conn.cursor()

    cursor.execute("CREATE TABLE customers(" \
    "id int ,"\

"name TEXT,"\

"surname TEXT,"\

 "email VARCHAR(25),"\

  "create_at TIMESTAMP,"\

  "last_seen TIMESTAMP"\
 ");")
    cursor.execute("SELECT * FROM customers")

else:
    print("Connection to the PostgreSQL encountered and error.")