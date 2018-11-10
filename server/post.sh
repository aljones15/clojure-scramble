curl --header "Content-Type: application/json" \
 --request POST \
 --data '{"words": ["cat", "at"]}' \
http://localhost:4139/scramble

curl --header "Content-Type: application/json" \
 --request POST \
 --data '{"words": ["cat", "bt"]}' \
http://localhost:4139/scramble
