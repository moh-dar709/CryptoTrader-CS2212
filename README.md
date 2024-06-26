# CS2212 Project: CryptoTrader
To successfully login: use one of the username and password combinations on the credentials text file. Usernames will be on the odd numbered lines, passwords will be on the even numbered lines.

#### List of credentials currently in the file: (username - password)
- test1 - 12345
- test2 - 654321
- kostas - cs2212

Any of the following coins can be inputted: bitcoin, cardano, ethereum, eos, litecoin, solana, dogecoin, tether, polkadot, terrausd.

For trading strategies to successfully work, please input: "Broker-1", "Broker-2", "Broker-3" "Broker-4" into the trading client box. For coin names, input coins seperated by a comma with no space in between them (i.e. "ethereum,bitcoin").

### Broker-1 specializes in Bitcoin
- Strategy-A uses bitcoin and cardano.
- Strategy-B uses bitcoin and polkadot.
- Strategy-C uses bitcoin and solana.
- Strategy-D uses bitcoin and cardano.

### Broker-2 specializes in Ethereum
- Strategy-A uses ethereum and litecoin.
- Strategy-B uses ethereum and solana.
- Strategy-C uses ethereum and polkadot.
- Strategy-D uses ethereum and eos.

### Broker-3 specializes in Tether
- Strategy-A uses tether and terrausd.
- Strategy-B uses tether and dogecoin.
- Strategy-C uses tether and eos.
- Strategy-D uses tether and polkadot.

### Broker-4 specializes in Dogecoin
- Strategy-A uses dogecoin and solana.
- Strategy-B uses dogecoin and bitcoin.
- Strategy-C uses dogecoin and cardano.
- Strategy-D uses dogecoin and terrausd.


We got inspiration for the LoginSystem class from a tutorial found online: https://www.tutorialsfield.com/login-form-in-java-swing-with-source-code/. Only the JFrame elements were inspired by the tutorial, integrating the LoginSystem into the the program was done by us.


### API Limitations
According to CoinGecko's Terms of Service (https://www.coingecko.com/en/api_terms), CoinGecko API is limited to 8 calls per second. Due to this, multiple trades at once may cause errors.
