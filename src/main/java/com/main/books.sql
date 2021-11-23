INSERT INTO books(author, title, price) VALUES
('H.P.Lovecraft','The Call of Cthulhu',100.81);
INSERT INTO books(author, title, price) VALUES
('F.S.Fitzgerald','This Side of Paradise',90.11);
INSERT INTO books(author, title, price) VALUES
('R.D.Bradbury','The Illustrated Man',95.54);


--or-----------------------------------------------

curl -X POST --location "http://localhost:8082/books" \
    -H "Content-Type: application/json" \
    -d "{
          \"author\" : \"H.P.Lovecraft\",
          \"title\" : \"The Call of Cthulhu\",
          \"price\" : 100.81
        }"

curl -X POST --location "http://localhost:8082/books" \
    -H "Content-Type: application/json" \
    -d "{
          \"author\" : \"F.S.Fitzgerald\",
          \"title\" : \"This Side of Paradise\",
          \"price\" : 90.11
        }"

curl -X POST --location "http://localhost:8082/books" \
    -H "Content-Type: application/json" \
    -d "{
          \"author\" : \"R.D.Bradbury\",
          \"title\" : \"The Illustrated Man\",
          \"price\" : 95.54
        }"