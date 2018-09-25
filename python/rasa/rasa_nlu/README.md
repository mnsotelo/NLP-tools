# Intent and entity extraction with Rasa-nlu tensorflow server

Preconfigured setup for intent and entity extraction with rasa-nlu tensorflow embeddings

# Requirements

1. **Python 3.5**. Also you can create a virtualenv with python 3.5 (`virtualenv -p python3.5 venv`) and activate it (`source venv/bin/activate`). 
2. Dependencies libraries with requirements file: `pip install -r requirements.txt`. Or use : `pip install rasa_nlu` 
and `pip install rasa_nlu[tensorflow]`.

# How to use it

1. Collect your data and add it inside **/data** folder, make sure you follow the standard rasa format, you can check an example in **data/demo-json**. There is a nice tool for generating datasets for rasa_nlu, please check [Chatito](https://github.com/rodrigopivi/Chatito).
2. Train the model. In the project folder write: `python -m rasa_nlu.train --config configs/config_embedding.yml --data data/rasa/demo-rasa.json --path projects`.
The **--config** parameter specifies the path to the configuration file of the server; **--data** parameter specifies the data file path; and finally **--path** indicates in which
folder the generated model will be stored, if the folder doesn't exist it will create it.
3. Launch the server using your new model. In the project folder write the following command: `python -m rasa_nlu.server -c configs/config_embedding.yml --path projects/`.
The **-c** parameter indicates the location of the configuration file and **--path** indicates the location of the model to load (If given just the folder, it will load the newest model).

# Credits

[Rasa_nlu team](https://rasa.com/docs/nlu/)
