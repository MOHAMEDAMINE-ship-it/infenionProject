import numpy as np
from flask import Flask,abort,jsonify,request
import json
from flask_cors import CORS, cross_origin


#Import the libraries
import pandas as pd
import numpy as np
from sklearn.metrics.pairwise import cosine_similarity
from sklearn.feature_extraction.text import CountVectorizer

#load the data
#store the data
df = pd.read_csv('trips.csv')
#show the first 3 rows of data
print(df.head(3))

#get a count of the number of rows in the data set and the number of columns
df.shape

#create a list of important columns for the recommendation engine
columns =['location','date','note','price']

#show the data
print(df[columns].head(3))

#check for any missing values in the important columns
df[columns].isnull().values.any()

#create a function to combine the values of the important columns into a single string
def get_important_features(data):
  important_features =[]
  for i in range(0, data.shape[0]):
    important_features.append(str(data['location'][i])+' '+str(data['date'][i])+' '+str(data['note'][i])+ ' '+str(data['price'][i]))

  return important_features

#create a column to hold the combined strings
df['important_features'] = get_important_features(df)
#show the data
print(df.head(3))

#convert the text to a matrix of token counts
cm= CountVectorizer().fit_transform(df['important_features'])

#get the cosine similarity matrix from the count matrix
cs = cosine_similarity(cm)
#print the cosine similarity matrix
print(cs)

#get the shape of similarity matrix
print(cs.shape)

df['id']=df.index

print(df.head(3))



app = Flask(__name__)
CORS(app, support_credentials=True)


@app.route('/api',methods=['GET'])
@cross_origin(supports_credentials=True)
def getRecommandation():
    date=request.args.get("date")
    note=request.args.get("note")
    price=request.args.get("price")
    location=request.args.get("location")


    info_id=df[(df.location==location) | (df.date==date) | (df.note==note) | (df.price==price)]['id'].values[0]
    #print(cs[info_id])
    scores = list(enumerate(cs[info_id]))

    sorted_scores = sorted(scores,key = lambda x:x[1],reverse = True)
    sorted_scores = sorted_scores[1:]
    #print(len(sorted_scores))
    j=0
    variable=[]
    for item in sorted_scores:
        variable.append({'date':df[df.id == item[0]]['date'].values[0],'location':df[df.id == item[0]]['location'].values[0],'note':df[df.id == item[0]]['note'].values[0]})
        j = j+1
        if j>6:
            break

    return jsonify(variable)


if __name__ == '__main__':
    app.run(port=9000,debug=True)
