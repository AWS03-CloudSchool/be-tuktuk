#!/bin/bash

mysql -u "root" -p "1235" <<EOSQL
CREATE DATABASE IF NOT EXISTS SOCCER;
EOSQL